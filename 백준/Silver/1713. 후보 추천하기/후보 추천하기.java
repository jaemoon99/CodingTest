import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int rec = sc.nextInt();
        
        Student students[] = new Student[101];
        List<Student> frame = new ArrayList<>();
        
        for(int i = 0; i < rec; i++) {
			int num = sc.nextInt();
			// 처음인 경우
			if(students[num] == null) {
				students[num] = new Student(num, 0, 0, 0);
			}
			
			// 이미 게시된 경우
			if(students[num].check == 1) {
				students[num].cnt++;
			}
			
			else {
				// 게시판이 꽉 찬 경우
				if(frame.size() == n) {
					// 추천수 적은 순, 오래된 순 으로 정렬
					Collections.sort(frame, new Comparator<Student>() {
						public int compare(Student o1, Student o2) {
							if(o1.cnt == o2.cnt) {
								return o1.seq - o2.seq;
							}
							return o1.cnt - o2.cnt;
						}
					});
					
					// 삭제
					frame.get(0).check = 0;
					frame.remove(0);
				}
				
				// 추가
				students[num].cnt = 1;
				students[num].seq = i;
				students[num].check = 1;
				frame.add(students[num]);
			}
        }
		
		Collections.sort(frame, (o1, o2) -> o1.num - o2.num);
		for(Student i : frame) {
			System.out.print(i.num + " ");
		}
        

        sc.close();
    }
    
    static class Student{
		int num;
		int cnt;
		int seq;
		int check;
		
		public Student(int num, int cnt, int seq, int check) {
			this.num = num;
			this.cnt = cnt;
			this.seq = seq;
			this.check = check;
		}
	}
}
