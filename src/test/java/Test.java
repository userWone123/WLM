import com.wlm.po.Grade;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * @author 86182
 * @create 2019-11-20-11:24
 */
public class Test {
    @org.junit.Test
    public void test(){
        //1.获取SessionFactory
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        //2.生产会话 通过opensession 获取session对象
        Session session=sessionFactory.openSession();
        //3.开启一个事务
        Transaction transaction=session.beginTransaction();
        //4.1执行查询
        Grade grade =session.get(Grade.class,1);
        System.out.println("grade = "+grade);
        //4.2执行查询(查询单条数据)🔍  //get load都可以
        Grade grade1=session.get(Grade.class,1);
        System.out.println("grade1 = "+grade1);

        //4.3 执行查询(查询单条数据)    hql 语句
                     //Grade实体类
        String hql1="from Grade where id=?";
        String hql2="from Grade where id=:id";
        Query query = session.createQuery(hql2);
        //query.setParameter(0,1);//hql1传值   占位符从0开始
        query.setParameter("id",1);//hql2传值 自定义占位符名

        Object o = query.uniqueResult();//只针对于 已经知道只有一条语句时才能使用
        System.out.println("o = " + o);


        //5查询全部
        Query query1 = session.createQuery("from com.yyh.po.Grade");
        List<Grade> list = query1.list();
        for (Grade stu : list) {
            System.out.println("stu = " + stu);
        }
    }

    /*
    * 增加操作
    * */
    @org.junit.Test
    public void testInsert() {

        //1.获取SessionFactory
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        //2.生产会话 通过opensession 获取session对象
        Session session=sessionFactory.openSession();
        //3.开启一个事务DeskTopShare2.0.3
        Transaction transaction=session.beginTransaction();
        //增加
        Grade stuu=new Grade();
        stuu.setGname("张三");
        stuu.setGid(5);
        session.save(stuu);
    }
   /* @org.junit.Test
    public void testSaveOrUpdate() {

         Grade grade=new Grade();
         grade.setGname("得得得得");
        session.SaveOrUpdate(grade);
    }*/
}
























