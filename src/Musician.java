//Raj Keswani
//January 22, 2024
public class Musician extends Person
{
    private String instrument;

    public Musician(String firstName, String lastName, String phoneNumber, String instrument)
    {
        super(firstName, lastName, phoneNumber);
        this.instrument = instrument;
    }

    public String getInstrument()
    {
        return instrument;
    }

    public String toString()
    {
        return super.toString() + " Instrument: " + instrument;
    }
}