import java.util.*;
class Solution {
    private boolean[] visited;
    private List<String> answer;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        dfs("ICN", "ICN", tickets, 0);
        // 경로가 여러개 나올 경우 알파벳 순으로 정렬
        Collections.sort(answer); 
        return answer.get(0).split(" ");
    }
    
    private void dfs(String current, String path, String[][] tickets, int depth){
        if(depth == tickets.length)  // 모든 티켓 다 방문한 경우
            answer.add(path);
        
        for(int i=0; i< tickets.length; i++){
            //방문 안했고 현재 위치랑 0번 인덱스가 같으면
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i]= true; 
                dfs(tickets[i][1],path+" "+tickets[i][1],tickets, depth+1);
                visited[i]= false; 
            }
        }
    }
}