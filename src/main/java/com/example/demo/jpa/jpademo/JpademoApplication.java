package com.example.demo.jpa.jpademo;

import com.example.demo.jpa.jpademo.entity.Stock;
import com.example.demo.jpa.jpademo.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class JpademoApplication  implements CommandLineRunner {

//	@Autowired
//	UserRepo repo;
//
//	@Autowired
//	StockRepo stockRepo;



	public static void main(String[] args) {

		{
			SpringApplication.run(JpademoApplication.class, args);


		}
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		User user = new User();
		User user2 = new User();

		user.setAge(22);
		user.setFName("sarath");
		user.setLName("mondol");

		user2.setAge(32);
		user2.setFName("bharath");
		user2.setLName("ratan");

		Stock stock=new Stock();
		stock.setStkQty(10);
		stock.setUsr(user);
		stock.setStockName("BOA");

		Stock stock2=new Stock();
		stock2.setStkQty(7);
		stock2.setUsr(user2);
		stock2.setStockName("CITI");


		//stock.setUsr(user);

		//assert repo != null;
		//repo.save(user);
		//repo.save(user2);



		//stockRepo.save(stock);

		//stockRepo.save(stock2);

		//System.out.println(stockRepo.findById(2)+ " CURRENT THREAD   "+ Thread.currentThread().getName());
		//repo.findById(1);
		//System.out.println(repo.findById(1));

		//System.out.println("done");



//		List<Combo> l=repo.getUsers().stream().map(x-> new Combo(
//			x.get(0, String.class),
//					x.get(1, String.class),
//					x.get(2, Integer.class),
//					x.get(3, String.class),
//					x.get(4, String.class),
//					x.get(5, Integer.class))
//
//		).collect(Collectors.toList());
//
//		l.forEach(System.out::println);


//		repo.getUsers2().forEach(
//				(x-> System.out.println(x.getfName() + " " +x.getName() +" "+x.getTime()))
//		);



	}
}





