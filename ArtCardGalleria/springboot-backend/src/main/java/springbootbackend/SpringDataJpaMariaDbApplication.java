package springbootbackend;

//import net.javaguides.springbootbackend.entity.Employee;
//import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringbootBackendApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringbootBackendApplication.class, args);
//	}
@SpringBootApplication
public class SpringDataJpaMariaDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMariaDbApplication.class, args);
	}

}
//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Override
//	public void run(String...args) throws Exception {
//
//		Employee employee1 = Employee.builder()
//				.firstName("Ramesh")
//				.lastName("Fadatare")
//				.email("abc@hotmail.com")
//				.build();
//
//		Employee employee2 = Employee.builder()
//				.firstName("Tony")
//				.lastName("Stark")
//				.email("tc@hotmail.com")
//				.build();
//
//		Employee employee3 = Employee.builder()
//				.firstName("John")
//				.lastName("Cena")
//				.email("jc@hotmail.com")
//				.build();
//
//		employeeRepository.save(employee1);
//		employeeRepository.save(employee2);
//		employeeRepository.save(employee3);
//
//	}

//}
