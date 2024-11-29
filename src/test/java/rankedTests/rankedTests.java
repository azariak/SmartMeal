import interface_adapter.ranked.RankedViewModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class rankedTests {

//    @Test
//    public void testGetRankings() {
//        RankedViewModel viewModel = new RankedViewModel();
//
//        // Expected rankings
//        String[] expectedRankings = {
//                "★☆☆☆☆",
//                "★★☆☆☆",
//                "★★★☆☆",
//                "★★★★☆",
//                "★★★★★"
//        };
//
//        // Call the method
//        String[] actualRankings = viewModel.getRankings();
//
//        // Check each actual ranking to ensure it is in the expected array
//        for (String actualRanking : actualRankings) {
//            boolean found = false;
//            for (String expectedRanking : expectedRankings) {
//                if (actualRanking.equals(expectedRanking)) {
//                    found = true;
//                    break;
//                }
//            }
//            // Fail the test if an actual ranking is not found in expected rankings
//            assertTrue(found, "Ranking '" + actualRanking + "' was not expected.");
//        }
//
//        // Pass the test if all rankings are valid
//        assertEquals(expectedRankings.length, actualRankings.length,
//                "The number of rankings should match the expected count.");
//    }


    @Test
    public void testGetViewName() {
        RankedViewModel viewModel = new RankedViewModel();

        // Expected view name
        String expectedViewName = "Ranked Recipes View";

        // Call the method
        String actualViewName = viewModel.getViewName();

        // Assert that the view name is correct
        assertEquals(expectedViewName, actualViewName, "View name should match the expected value.");
    }
}
