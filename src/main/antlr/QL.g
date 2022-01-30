grammar QL;

start       : (formula | nExp | sExp)? EOF;

formula     : nExp relNOp nExp                              #AtomicN
            | sExp relSOp sExp                              #AtomicS
            | unConn formula                                #Unary
            | formula binConn formula                       #Binary
            | quantifier var ':' type '.' formula           #Quantified
            | '(' formula ')'                               #Bracketed
            ;

unConn      : NOT ;
binConn     : AND | OR | IMPLY | EQUIV ;
quantifier  : FORALL | EXISTS ;
var         : ID ;
relSOp      : EQ ;

nExp        : NUMBER                                #Nat
            | var                                   #VarRef
            | MATRIX '[' nExp ',' nExp ']'          #SalesAt
            | SALES_FOR_M '(' MATRIX ')'            #SalesForM
            | SALES_FOR_D '(' MATRIX ',' nExp ')'   #SalesForD
            | SALES_FOR_P '(' MATRIX ',' nExp ')'   #SalesForP
            | SIZE '(' sExp ')'                     #Size
            | nExp binNOp nExp                      #BinaryNExp
            | '(' nExp ')'                          #BracketedNExp
            ;

binNOp      : PLUS | MINUS | ASTRIX | SLASH ;
relNOp      : EQ | NEQ | LT | LTE | GT | GTE ;

sExp        : type                                  #TypeRef
            | '{' var ':' type '|' formula '}'      #SetCompr
            | sExp binSOp sExp                      #BinarySExp
            | '(' sExp ')'                          #BracketedSExp
            ;

binSOp      : PLUS | AMPER | MINUS;
type        : DAY | PRODUCT | SALE ;

DAY           : D A Y ;
PRODUCT       : P R O D ;
SALE          : S A L E ;
MATRIX        : M;
SALES_FOR_M   : S A L E S F O R M ;
SALES_FOR_D   : S A L E S F O R D ;
SALES_FOR_P   : S A L E S F O R P ;
SIZE          : S I Z E ;
FORALL        : F O R A L L ;
EXISTS        : E X I S T S ;

EQ      : ('=' | '==') ;
LT      : '<' ;
GT      : '>' ;
NEQ     : '!=' ;
LTE     : '<=' ;
GTE     : '>=' ;

PLUS    : '+' ;
MINUS   : '-' ;
ASTRIX  : '*' ;
SLASH   : '/' ;
AMPER   : '&';

AND     : ('&&' | A N D) ;
OR      : ('||' | O R) ;
IMPLY   : ('=>' | I M P L I E S) ;
EQUIV   : ('<=>' | I F F) ;
NOT     : ('!' | N O T) ;

ID      : [a-zA-Z][a-zA-Z0-9]* ;
NUMBER  : [0-9]+ ;

LINE_COMMENT
        : '%%' ~[\r\n]* (EOF|'\r'? '\n')
            -> skip
        ;

WS
        :   [ \r\t\n]+ -> channel(HIDDEN)
        ;

fragment A  :('a' | 'A') ;
fragment B  :('b' | 'B') ;
fragment C  :('c' | 'C') ;
fragment D  :('d' | 'D') ;
fragment E  :('e' | 'E') ;
fragment F  :('f' | 'F') ;
fragment G  :('g' | 'G') ;
fragment H  :('h' | 'H') ;
fragment I  :('i' | 'I') ;
fragment J  :('j' | 'J') ;
fragment K  :('k' | 'K') ;
fragment L  :('l' | 'L') ;
fragment M  :('m' | 'M') ;
fragment N  :('n' | 'N') ;
fragment O  :('o' | 'O') ;
fragment P  :('p' | 'P') ;
fragment Q  :('q' | 'Q') ;
fragment R  :('r' | 'R') ;
fragment S  :('s' | 'S') ;
fragment T  :('t' | 'T') ;
fragment U  :('u' | 'U') ;
fragment V  :('v' | 'V') ;
fragment W  :('w' | 'W') ;
fragment X  :('x' | 'X') ;
fragment Y  :('y' | 'Y') ;
fragment Z  :('z' | 'Z') ;