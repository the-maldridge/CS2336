
public class TestMember {
    public static void main(String[] args){
        Member member1=new Member();
        member1.displayMemberInfo();
        System.out.println();
        Member member2=new Member("Jonathan", "Napkin");
        member2.displayMemberInfo();
        System.out.println();
        Member member3=new Member(2000,"Alicia", "Apron", 1500);
        member3.displayMemberInfo();

	//Use of toString() method
        System.out.println("\nFollowing is the demonstration of the toString() method use:");
        System.out.println(member1.toString());
    }
}
