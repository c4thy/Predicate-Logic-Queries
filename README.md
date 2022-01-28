# Evaluating predicate logic queries for time series data 


## Overview
The purpose of this project is to demonstrate practical experience with
-  expressing properties formally and declaratively using queries and constraints in first-order logic, 
-  defining the syntax of a language through the use of a parser, 
-  defining the semantics of a language through the implementation of an evaluator, and
-  incremental software development,

as well as exposure to relevant software engineering tooling such as 
-  parser generators such as ANTLR, and
-  build systems such as Gradle.
        
## Intro
In this project, I have implemented an evaluator for a language called QL (Query Language). Starter code has been provided and already contains code to read in all necessary input. In particular, a parser and an abstract syntax tree builder for QL are given, which will construct an appropriate internal representation for your evaluation code to operate on. 

QL is based on predicate logic and has been designed specifically to express properties of and queries for 2-dimensional arrays of sales data. Every row in such an array represents a different product, while every column represents a different day. Individual products (or days) in the array will be referred by the (1-based) number of the row (or column) they are in. Consider, for instance, the array:
<pre>  3  2  5 10  0
  0  1  4  0  9
  1  9  2  3  2
  2  0  1  2  2
</pre>

This array contains sales amounts for 4 products (which can be referred by the natural numbers 1 to 4) on 5 days (which can be referred to by the natural numbers 1 to 5). It expresses that, e.g., 3 units of product 1 were sold on day 1, 4 units of product 2 were sold on on day 3, and 10 units of product 1 were sold on day 4. 

## Description of QL
QL allows the formulation of formulas and expressions that are evaluated using such a sales array. Formulas can capture properties such as <i>"no product had a day with no sales"</i>, while expressions can be used to express queries to, e.g., collect <i>"the set of days with at least one product with no sales"</i>, or determine <i>"the number of products with sales greater than 10 on day 1"</i>. The syntax of QL is defined by the following grammar. 

```g4   
   // formulas
   <Formula>       ::= <AtomicN> | <AtomicS> | <Unary> | <Binary> | <Quantified> 
   <AtomicN>       ::= <NExp> <RelNOp> <NExp>
   <AtomicS>       ::= <SExp> <RelSOp> <SExp>
   <Unary>         ::= <UnConn> <Formula> | <Bracketed>
   <Binary>        ::= <Formula> <BinConn> <Formula>
   <Quantified>    ::= <Quantifier> <Var> ':' <Type> '.' <Formula>
   <Bracketed>     ::= '('<Formula>')'
   <UnConn>        ::= '!' | 'not'
   <BinConn>       ::= '&&' | 'and' | '||' | 'or' | '=>' | 'implies' | '<=>' | 'iff'
   <Quantifier>    ::= 'forall' | 'exists'
   <Var>           ::= Identifier
   <RelNOp>        ::= '=' | '<' | '<=' | '>' | '>='
   <RelSOp>        ::= '=' 
   
   // numeric expressions
   <NExp>          ::= <Nat> | <Var> | <SalesForM> | <SalesForD> | <SalesForP> | <SalesAt> | 
                       <Size> | <NExp><BinNOp><NExp> | <BracketedNExp>
   <Nat>           ::= natural number
   <SalesForM>     ::= 'salesForM(M)'
   <SalesForD>     ::= 'salesForD(M,'<NExp>')'
   <SalesForP>     ::= 'salesForP(M,'<NExp>')'
   <Size>          ::= 'size' '('<sExp>')'
   <SalesAt>       ::= 'M['<NExp>','<NExp>']'
   <BinNOp>        ::= '+' | '-' | '*' | '/'
   <BracketedNExp> ::= '('<NExp>')'
   
   // set expressions
   <SExp>          ::= <Type> | <SetCompr> | <BinarySExp> | <BracketedSExp>
   <SetCompr>      ::= '{'<Var> ':' <Type> '|' <Formula>'}'
   <BinarySExp>    ::= <SExp> <BinSOp> <SExp> 
   <BracketedSExp> ::= '('<SExp>')'
   <Type>          ::= 'Day' | 'Prod' | 'Sale' 
   <BinSOp>        ::= '+' | '&' | '-'
```

Starting symbols are <tt>&lt;Formula&gt;</tt>, <tt>&lt;NExp&gt;</tt>, and <tt>&lt;SExp&gt;</tt>.
Formulas (non-terminal <tt>&lt;Formula&gt;</tt>) can contain quantification (over days, products, and sales amounts), the standard propositional connectives (negation, conjunction, disjunction, implication, and logical equivalence), as well as numerical expressions and set expressions. Numerical expressions (<tt>&lt;NExp&gt;</tt>) evaluate to a number (representing, e.g., a day, a product, a sales amount, the size of a set, or the result of some arithmetic operation on these). Set expressions (<tt>&lt;SExp&gt;</tt>) evaluate to sets of numbers.
To access the sales array, the following numeric expressions can be used:
-  <tt>M[&lt;NExp&gt;,&lt;NExp&gt;]</tt> which refers to a cell in the array with the arguments denoting, in this order, the product (i.e., row) and the day (i.e., column), respectively. E.g., for the sales array above, the expression <tt>M[2,3]</tt> would evaluate to 4.
-  <tt>salesForD(M,&lt;NExp&gt;)</tt> which refers to the sum of all sales on the day denoted by the argument. E.g., for the sales array above, <tt>salesForD(M,3)</tt> would evaluate to 12.
-  <tt>salesForP(M,&lt;NExp&gt;)</tt> which refers to the sum of all sales of the product denoted by the argument. E.g., for the sales array above, <tt>salesForP(M,3)</tt> would evaluate to 17.
-  <tt>salesForM(M)</tt> which refers to the sum of all sales for all products on all days. E.g., for the sales array above, <tt>salesForM(M)</tt> would evaluate to 58.
        
Moreover, numerical expressions can be built by computing the size of a set, or performing some standard artithmetic operation such as addition or multiplication, etc.

The following atomic set expressions are supported for building set expressions:
-  <tt>Day</tt>, which refers to the set of days used in the sales array. E.g., for the array above, <tt>Day</tt> would evaluate to the set <tt>{1,2,3,4,5}</tt>.
-  <tt>Prod</tt>, which refers to the set of products used in the sales array. E.g., for the array above, <tt>Prod</tt> would evaluate to the set <tt>{1,2,3,4}</tt>.
-  <tt>Sale</tt>, which refers to the set of sale amounts used in the sales array. E.g., for the array above, <tt>Sale</tt> would evaluate to the set <tt>{0,1,2,3,4,5,9,10}</tt>.
    
Set comprehension is also available. E.g., for the array above, <tt>{s:Sale | exists p:Prod. exists d:Day. M[p,d]=s && s&gt;=5}</tt> would evaluate to the set <tt>{5,9,10}</tt>. Finally, the standard set operations union (denoted by <tt>+</tt>), intersection (<tt>&</tt>), and difference (<tt>-</tt>) can also be used to build sets.

### Examples
- Using QL, the property <i>"no product had a day with no sales"</i> can be expressed by the formula <tt>!(exists p:Prod. exists d:Day. M[p,d]=0)</tt> or by the formula <tt>forall p:Prod. forall d:Day. !(M[p,d]=0)</tt>. 
- To determine <i>"the set of days with at least one product with no sales"</i> the set comprehension <tt>{d:Day | exists p:Prod. M[p,d]=0}</tt> can be used.
- The numerical expression <tt>size({p:Prod | M[p,1]&gt;10})</tt> will evaluate to the <i>"the number of products with sales greater than 10 on day 1"</i>.

## Parsing QL
Before a QL formula or expression can be evaluated, it must be parsed. The evaluator code provided already contains a parser. That parser has been generated with the ANTLR parser generator ([www.antlr.org](https://www.antlr.org)). After the QL formula or expression has been read in, the parser will, assuming that it is syntactically correct, build and return an internal representation of it in the form of an [abstract syntax tree (AST)](https://en.wikipedia.org/wiki/Abstract_syntax_tree). The following class diagram describes the classes and their relationships (attributes) used to define ASTs (note the correspondence between this class diagram and the grammar). 

![Class diagram for ASTs of QL](/docs/astClassDiag_cropped.jpg)

In the diagram above, the top-level classes <tt>Formula</tt>, <tt>NExp</tt>, and <tt>SExp</tt> are high-lighted for readability; their names are shown in italics, because they are abstract; classes labeled with 'E' in the upper right-hand corner are enumerations; also, all associations have an implicit 'exactly 1' multiplicity constraint on their target end (e.g., objects of type <tt>AtomicS</tt> have two attributes <tt>lhs</tt> and <tt>rhs</tt> each of which will point to exactly one object of type <tt>SExp</tt>). Note that the grammar contains productions allowing for bracketed formulas and expressions, but, for simplicity, the class diagram does not contain classes for these. Instead, AST builder produces an instance of the type of the bracketed formula or expression (e.g., the type of the root object of the AST for <tt>(2+3)</tt> will be <tt>BinNExp</tt>, rather than <tt>BracketedNExp</tt>).

The following object diagram shows the AST created for the formula <tt>forall d:Day. exists p:Prod. !(M[p,d]>5)</tt>. 

![Object diagram representing AST for formula above](/docs/ast2.jpg)

The starter code contains code that will create these object diagrams for the input formula or expression. 

## Provided evaluator code

The structure of the starter code is as follows: The QL grammar for ANTLR is stored in file [<tt>src/main/antlr/QL.g</tt>](src/main/antlr/QL.g), and after the build, the generated parser will reside in directory <tt>src/generated/java/ql</tt>. Directory [<tt>src/main/java</tt>](src/main/java/) contains code to
- build the AST after the parsing (subdirectory [<tt>ast</tt>](src/main/java/ast/)), 
- read in a sales array from a file in csv format (class [<tt>CSVReader</tt>](src/main/java/CSVReader.java)), 
- implement an <i>environment</i>, i.e., a data structure that stores the binding of variables to values (class [<tt>Env</tt>](src/main/java/Env.java)), 
- declare methods to evaluate formulas and expressions (class [<tt>BaseEval</tt>](src/main/java/BaseEval.java)), and
- declare exceptions for problems that might occur during the evaluation (class [<tt>BaseEval</tt>](src/main/java/BaseEval.java)).

It also contains the class [<tt>Main</tt>](src/main/java/Main.java) which
- reads in the command line arguments,
- calls the csv reader, the parser, and the AST builder (and, optionally, draws the AST of the input formula or expression),
-  creates an instance of the [<tt>Eval</tt>](src/main/java/Eval.java) class which has access to the sales array read in and starts the evaluation by invoking the top-level [<tt>eval</tt>](src/main/java/BaseEval.java#L56-L66) method with the AST of the input formula or expression as argument (line [<tt>boolean result = new Eval(data).eval(ast)</tt>](src/main/java/Main.java#L112)), and then
-  outputs the evaluation result, or an error message should an exception be thrown during the evaluation. 


### Running the provided evaluator code
Using Git-Bash, the following will clone, build, and run all unit tests in [<tt>src/test/java</tt>](src/test/java).

```$xslt
git clone https://github.com/CISC422/<your_repository> a1
cd a1 && ./gradlew test
```

To build a runnable jar file <tt>eval.jar</tt> with Git-Bash run the Gradle (a build tool) wrapper in directory <tt>a1</tt>
```$xslt
./gradlew jar
```

The evaluator supports the following command line options:
```$xslt
Usage: java -jar eval.jar (-f=<fOrExpr> | -i) [-hVx] <mFile>
      <mFile>     Input data file
  -f=<fOrExpr>    Formula or expression to evaluate
  -h, --help      Show this help message and exit
  -i              Parse input from stdin
  -V, --version   Print version information and exit
  -x              Show AST
```
