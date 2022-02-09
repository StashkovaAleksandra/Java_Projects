// TODO: Add the appropriate file header comment

// TODO: Add the appropriate class header comment
public class CovidCalculator {
    private DataPoint[] points;  // The data points to use in the calculations

    // TODO: add comment and implement method.
    public CovidCalculator(DataPoint[] input) {
        // TODO: Remove the line below and implement this method so that
        // it makes a new array for points and copies the entries from input
        // into points.
        this.points = new DataPoint[input.length];
        for (int i = 0; i < input.length; i++) {
            points[i] = input[i];
        }
    }

    // TODO: add comment and implement method.
    public DataPoint[] getPoints() {
        return this.points;
    }

    // TODO: Add comment and implement method.
    public double findAverageCases(String date) {
        double sumTotalCases = 0;
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i].getDate().equals(date)) {
                sumTotalCases += points[i].getTotalCases();
                counter++;
            }
        }
        if (counter != 0) {
            return sumTotalCases / counter;
        } else {
            return 0;
        }
    }

    // TODO: Add comment and implement method.
    public String findRaceWithHighestCases(String date, String state) {
        int max = -1;
        String race = null;
        for (int i = 0; i < points.length; i++) {
            if (points[i].getDate().equals(date) && points[i].getState().equals(state)) {
                for (int j = 0; j < points[i].numRaces; j++) {
                    if (max < points[i].getCasesByRace(j)) {
                        race = points[i].getRaceName(j);
                        max = points[i].getCasesByRace(j);
                    }
                }
            }
        }
        return race;
    }

    // TODO: Add comment and implement method.
    public String findDateWithHighestCases(String state) {
        int max = -1;
        String date = null;
        for (int i = 0; i < points.length; i++) {
            if (points[i].getState().equals(state) && max < points[i].getTotalCases()) {
                max = points[i].getTotalCases();
                date = points[i].getDate();
            }
        }
        return date;
    }


    public String findDateWithLowestCases(String state) {
        int min = Integer.MAX_VALUE;
        String date = null;
        for (int i = 0; i < points.length; i++) {
            if (points[i].getState().equals(state) && min > points[i].getTotalCases()) {
                min = points[i].getTotalCases();
                date = points[i].getDate();
            }
        }
        return date;
    }
}