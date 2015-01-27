/* begin-gcd-recursive */

def gcd(a : Int, b : Int) = if (b == 0) a else gcd(b, a % b)
