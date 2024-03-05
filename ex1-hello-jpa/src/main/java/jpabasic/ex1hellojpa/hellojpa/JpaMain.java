package jpabasic.ex1hellojpa.hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            //데이터 삽입
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);



            Member findMember = em.find(Member.class , 2L);
            System.out.println(findMember.getName());
            findMember.setName("HelloJPA");

            List<Member> result = em.createQuery("select m from Member as m" , Member.class).getResultList();

            for (Member m : result){
                System.out.println("member.name = " + m.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }



        emf.close();
    }
}
