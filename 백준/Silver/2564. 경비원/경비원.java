import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 블록의 가로 길이(w)와 세로 길이(h) 입력
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        // 상점의 수(n) 입력
        int n = scanner.nextInt();
        int[] stores = new int[n];

        // 상점들의 위치를 입력 받아서 배열에 저장
        for (int i = 0; i < n; i++) {
            int direction = scanner.nextInt();
            int distance = scanner.nextInt();
            stores[i] = getPosition(w, h, direction, distance);
        }

        // 경비원의 위치 입력
        int guardDirection = scanner.nextInt();
        int guardDistance = scanner.nextInt();
        int guardPosition = getPosition(w, h, guardDirection, guardDistance);

        // 총 둘레 길이 계산
        int totalLength = 2 * (w + h);

        // 최단 거리 계산
        int totalDistance = 0;
        for (int store : stores) {
            int clockwiseDist = Math.abs(store - guardPosition);
            int counterClockwiseDist = totalLength - clockwiseDist;
            totalDistance += Math.min(clockwiseDist, counterClockwiseDist);
        }

        // 결과 출력
        System.out.println(totalDistance);

        scanner.close();
    }

    // 위치를 둘레를 따라 일렬로 펼쳐진 직선상의 좌표로 변환하는 함수
    public static int getPosition(int w, int h, int direction, int distance) {
        if (direction == 1) { // 북쪽
            return distance;
        } else if (direction == 2) { // 남쪽
            return 2 * w + h - distance;
        } else if (direction == 3) { // 서쪽
            return 2 * (w + h) - distance;
        } else if (direction == 4) { // 동쪽
            return w + distance;
        }
        return 0; // 올바른 방향이 아닌 경우, 기본값으로 0을 반환
    }
}