package test;

import main.TrackingSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrackingSetTest {
    private TrackingSet<Integer> trackingSet;

    @BeforeEach
    public void setUp(){
        trackingSet = new TrackingSet<>();
    }

    @Test
    public void addingElementIncreasesAdditionCount(){
        trackingSet.add(1);
        trackingSet.add(1);
        trackingSet.add(3);
        Assertions.assertEquals(2, trackingSet.getAdditionsCount());
    }

    @Test
    public void removingElementIncreasesAdditionCount(){
        trackingSet.add(1);
        trackingSet.remove(1);
        trackingSet.remove(2);
        trackingSet.remove(134);
        Assertions.assertEquals(1, trackingSet.getRemovalsCount());
    }

    @Test
    public void checkingGetOperationCount(){
        trackingSet.add(32);
        trackingSet.remove(9);
        trackingSet.add(11);
        trackingSet.remove(11);
        Assertions.assertEquals(3, trackingSet.getOperationsCount());
    }

    @Test
    public void addingElementThatAlreadyOnSet(){
        trackingSet.add(16);
        trackingSet.add(16);
        Assertions.assertEquals(1, trackingSet.getAdditionsCount());
    }

    @Test
    public void removingAlreadyRemovedElement(){
        trackingSet.add(4);
        trackingSet.remove(4);
        trackingSet.remove(6);
        Assertions.assertEquals(1, trackingSet.getRemovalsCount());
    }

    @Test
    public void removingNonExistingElement(){
        trackingSet.remove(8);
        trackingSet.remove(7);
        trackingSet.remove(1);
        Assertions.assertEquals(0, trackingSet.getRemovalsCount());
    }
}
