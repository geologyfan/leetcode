package contest.t0301;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/1
 */

public class RankTeamsByVotes {
    public static void main(String[] args) {
        String[] votes = new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
        System.out.println(new RankTeamsByVotes().rankTeams(votes));
    }

    public String rankTeams(String[] votes) {
        int numOfVoters = votes.length;
        int numOfTeam = votes[0].length();
        HashMap<Character, Integer> hashMap = new HashMap<>(numOfTeam);
        char team;
        StringBuilder output = new StringBuilder(numOfTeam);
        TeamRank[] teamRanks = new TeamRank[numOfTeam];
        for (int i = 0; i < numOfTeam; i++) {
            team = votes[0].charAt(i);
            teamRanks[i] = new TeamRank(team, numOfTeam);
            hashMap.put(team, i);
        }
        for (int i = 0; i < numOfVoters; i++) {
            for (int j = 0; j < numOfTeam; j++) {
                team = votes[i].charAt(j);
                teamRanks[hashMap.get(team)].rank[j]++;
            }
        }
        Arrays.sort(teamRanks);
        for (int i = 0; i < numOfTeam; i++) {
            output.append(teamRanks[i].name);
        }
        return output.toString();
    }

//    public String rankTeams2(String[] votes) {
//        int numOfVoters = votes.length;
//        int numOfTeam = votes[0].length();
//        HashMap<Character, Integer> hashMap = new HashMap<>(numOfTeam);
//        char team;
//        int temp;
//        StringBuilder output = new StringBuilder(numOfTeam);
//        for (int i = 0; i < numOfVoters; i++) {
//            for (int j = 0; j < numOfTeam; j++) {
//                team = votes[i].charAt(j);
//                if (hashMap.containsKey(team)) {
//                    temp = hashMap.get(team);
//                    temp += Math.pow(2, numOfTeam - j);
//                    hashMap.put(team, temp);
//                } else {
//                    hashMap.put(team, 2);
//                }
//            }
//        }
//    }


}

class TeamRank implements Comparable<TeamRank> {
    char name;
    int[] rank;

    public TeamRank(char c, int len) {
        name = c;
        rank = new int[len];
    }

    @Override
    public int compareTo(TeamRank o) {

        for (int i = 0; i < rank.length; i++) {
            if (this.rank[i] > o.rank[i]) {
                return -1;
            } else if (this.rank[i] < o.rank[i]) {
                return 1;
            }
        }
        return this.name - o.name;
    }


}
