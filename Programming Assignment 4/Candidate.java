public class Candidate {
    private String name;
    private String party;
    private int voteCount;

    public Candidate(String candidateName, String candidateParty) {
        name = candidateName;
        party = candidateParty;
        voteCount = 0;
    }

    public String getName() {
        return name;
    }
    public String getParty() {
        return party;
    }
    public int getVotes() {
        return voteCount;
    }
    public void setParty(String newParty) {
        party = newParty;
    }
    public void incrementVotes() {
        voteCount ++;
    }
}