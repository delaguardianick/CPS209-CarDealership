import java.util.Comparator;

/**
 * Nicolas de la Guardia
 * 500806448
 * new class sortBySafetyRating that implements comparator
 * used for collections.sort
 */
public class sortBySafetyRating implements Comparator<Car>
{
    public int compare(Car a, Car b)
    {
        if(a.getSafetyRating() == b.getSafetyRating())
            {return 0;}
        else if (a.getSafetyRating() < b.getSafetyRating())
            {return 1;}
        else {return -1;}
    }
}