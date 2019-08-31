public class Fraction {
    private int numerator, denominator;

    // constructors
    // in case the user enters both numerator and denominator
    public Fraction(int numerator, int denominator){
        if (denominator ==0){
            throw new IllegalArgumentException("Denominator mustn't be ZERO!");
        }

        // make the sign of the fraction if the user enters a -ve sign
        if ( (numerator<0 && denominator<0) || denominator<0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else{
            this.numerator = numerator;
            this.denominator = denominator;

        }
    } //_______________________________________________

    // if the user enters an integer (only numerator)
    public Fraction(int numerator){
        this(numerator,1);
    } //___________________________________________________________

    // general case with no inputs from user
    public Fraction(){
        this(0,1);
    }
//____________________________________________________________________________________________

    // Methods

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString(){
        // if the number is int not a fraction
        if(this.denominator==1){
            return this.numerator+"";
        }
        return this.numerator + "/" + this.denominator;
    }

    public double toDouble(){
        return (double) this.numerator / this.denominator;
    }

    //addition of two fractions
    public Fraction add(Fraction other){
        int newNumerator = this.numerator*other.denominator + this.denominator*other.numerator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator,newDenominator);
    }

    // subtraction
    public Fraction subtract(Fraction other){
        int newNumerator = this.numerator*other.denominator - this.denominator*other.numerator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator,newDenominator);
    }

    public Fraction multiply(Fraction other){
        int newNumerator = this.numerator*other.numerator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator,newDenominator);
    }

    public Fraction divide(Fraction other){
        // check if the other fraction = zero
        if(other.numerator==0){
            throw new IllegalArgumentException("Can't divide by Zero!");
        }

        int newNumerator = this.numerator*other.denominator;
        int newDenominator = this.denominator * other.numerator;

        return new Fraction(newNumerator,newDenominator);
    }

    // check equality of two fractions
    public boolean equals(Fraction other){
        if(this.numerator/this.denominator == other.numerator/other.denominator ){
            return true;
        }
        return false;
    }

    // Greatest Common Divisor
    public int gcd(int num1, int num2){
        // this is called The Euclidean Algorithm
        int remainder;
        while(num1 !=0 && num2 !=0){
            remainder = num1 % num2;
            num1=num2;
            num2=remainder;
        }
        return num1;
    }

    // using gcd method to get the lowest possible form of the fraction
    public void toLowestTerms(){
        int gcd = gcd(this.numerator,this.denominator);
        // if condition here to deal with case when fraction already in lowest form (gcd=0)
        if(gcd !=0) {
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }
    }



}
