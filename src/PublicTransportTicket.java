public class PublicTransportTicket {
	public static int solution(int[] A) {
		boolean [] travel=new boolean[31];
		for (int day : A)
		{
			travel[day]=true;
		}
		
		int dp[] = new int[31];
		dp[0]=0;
		
		for(int d=1;d<=30;d++) {
			//nếu không đi thì chi phí vẫn giữ nguyên 
			if(!travel[d])
				dp[d]=dp[d-1]; 
			else {
				int oneDayCost=dp[d-1]+2;
				int sevenDayCost=dp[Math.max(0, d-7)]+7;
				int fullMonthCost=25;
				dp[d]=Math.min(oneDayCost, Math.min(sevenDayCost,fullMonthCost));
			}
		}
		
		return dp[30];
		
		
	}
	public static void main(String[] args) {
		int [] A= {1,2,3,4,5,6,7,8};
		System.out.println(solution(A));
	}

}
