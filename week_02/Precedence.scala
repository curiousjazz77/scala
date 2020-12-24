a + b ^? c ?^ d less a ==> b | c

//parenthesized version that doesnt change the value
((a + b) ^? (c ?^ d)) less ((a ==> b) | c)

/*
## Precedence rules

- precedence of an operator is determined by its first character. The following list shows the characters in increasing order of priority
    - (all letters)
    - |
    - ^
    - &
    - < >
    - = !
    - :
    - + -
    - * / %
    - (all other special characters
*/
