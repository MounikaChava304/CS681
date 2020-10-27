package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPL {

	private String team;
	private int matchesPlayed;
	private int won;
	private int lost;
	private int points;
	private double netRunRate;

	public IPL(String team, int matchesPlayed, int won, int lost, int points, double netRunRate) {
		this.team = team;
		this.matchesPlayed = matchesPlayed;
		this.won = won;
		this.lost = lost;
		this.points = points;
		this.netRunRate = netRunRate;
	}

	public String getTeam() {
		return team;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getWon() {
		return won;
	}

	public int getLost() {
		return lost;
	}

	public int getPoints() {
		return points;
	}

	public double getNRR() {
		return netRunRate;
	}

	public static void main(String args[]) {
		ArrayList<IPL> iplTable = new ArrayList<>();

		iplTable.add(new IPL("Chennai Super Kings", 14, 9, 5, 18, +0.131));
		iplTable.add(new IPL("Sun Risers Hyderabad", 14, 6, 8, 12, +0.577));
		iplTable.add(new IPL("Royal Challengers Bangalore", 14, 5, 8, 11, -0.607));

		long numberOfTeams = iplTable.stream().count();
		System.out.println("Number of teams in IPL: " + numberOfTeams);

		IPL highestRunRateTeam = iplTable.stream().max(Comparator.comparing(IPL::getNRR)).get();
		System.out.println("IPL Team that has highest Net Run Rate : " + highestRunRateTeam.getTeam());

		IPL leastPointsTeam = iplTable.stream().min(Comparator.comparing(IPL::getPoints)).get();
		System.out.println("Team that has least points: " + leastPointsTeam.getTeam());

		List<IPL> sortedByNRR = iplTable.stream().sorted(Comparator.comparing(IPL::getNRR, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		System.out.println("Teams sorted by Net Run Rate: ");
		sortedByNRR.forEach((IPL ipl) -> System.out.println(ipl.getTeam() + ": " + ipl.getNRR()));

	}
}