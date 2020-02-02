import java.util.Comparator;
/**
 * Nicolas de la Guardia
 * 500806448
 * new class sortByMaxRange that implements comparator
 * used for collections.sort
 */
public class sortByMaxRange implements Comparator<Car>
{
    public int compare(Car a, Car b)
    {
        if(a.getMaxRange() == b.getMaxRange())
            {return 0;}
        else if (a.getMaxRange() < b.getMaxRange())
            {return 1;}
        else {return -1;}
    }
}