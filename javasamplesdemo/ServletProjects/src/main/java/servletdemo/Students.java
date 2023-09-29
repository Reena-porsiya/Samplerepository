package servletdemo;
  

    public class Students {
    	private String studentName;
    	public String collegeName;
    	
    	private int age;
    	
    	
    	public int getAge() {
    		return age;
    	}

    	public void setAge(int age) {
    		this.age = age;
    	}

    	public String getStudentName() {
    		return studentName;
    	}

    	public void setStudentName(String studentName) {
    		this.studentName = studentName;
    	}

    	public  String getCollegeName() {
    		return collegeName;
    	}

    	public  void setCollegeName(String collegeName) {
    		this.collegeName = collegeName;
    	}

    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		 Students obj = new  Students();
    		 obj.setStudentName("Ram");
    		 obj.setCollegeName("ABC college");
    		 
    		 
    		 Students obj1 = new  Students();
    		 obj1.setStudentName("raj");
    		 obj1.setCollegeName("PSNA college");
    		 
    		 
    		 Students obj2 = new  Students();
    		 obj2.setStudentName("renu");
    		 obj2.setCollegeName("RVS college");
    		 
    		 //ArrayList Students = new ArrayList();
    		 //Students.add(obj);
    		 //Students.add(obj1);
    		 //Students.add(obj2);
    		 
    		

    		 System.out.println("Student Name: " + obj.getStudentName());
             System.out.println("College Name: " + obj.getCollegeName());
             System.out.println();
             
             System.out.println("Student Name: " + obj1.getStudentName());
             System.out.println("College Name: " + obj1.getCollegeName());
             System.out.println();
             
             System.out.println("Student Name: " + obj2.getStudentName());
             System.out.println("College Name: " + obj2.getCollegeName());
             System.out.println();
             
             System.out.println("College Name: " + obj1.getCollegeName());
             
             System.out.println("College Name: " + obj.getCollegeName());
             
             System.out.println("College Name: " + obj2.getCollegeName());
             
    	}         
    	
    }