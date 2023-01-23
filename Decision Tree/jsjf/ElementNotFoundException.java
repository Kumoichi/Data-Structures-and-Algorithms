package jsjf;

public class ElementNotFoundException extends RuntimeException
{

    public ElementNotFoundException (String collection)
    {
        super (" element is not found in " + collection);
    }
}