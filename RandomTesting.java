
package randomtesting;

import  java.util.Random;
public class RandomTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Random r=new Random();
      
       String fullname="fullName"+r.nextInt();
       String firstname="firstName"+r.nextInt();
       String lastname="lastName"+r.nextInt();
       String address="address"+r.nextInt();
       long phoneNumber=(long)(Math.random()*1000000+333300000L);
       String email="email"+r.nextInt()+"gmail.com";
       
       
       System.out.println("the full name is "+fullname);
       System.out.println("the full name is "+firstname);
       System.out.println("the full name is "+lastname);
       System.out.println("the full name is "+address);
       System.out.println("the full name is "+phoneNumber);
       System.out.println("the full name is "+email);
       
    }
    
}
