package ir.khu.jaobshaar.services;

import ir.khu.jaobshaar.component.authenticate.AuthenticationManager;
import ir.khu.jaobshaar.component.user.EmployerManager;
import ir.khu.jaobshaar.config.jwt.JwtResponse;
import ir.khu.jaobshaar.entity.model.User;
import ir.khu.jaobshaar.repository.UserRepository;
import ir.khu.jaobshaar.service.domain.JobDomain;
import ir.khu.jaobshaar.service.dto.user.UserDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

public class EmployerServiceTest {

	private final EmployerManager employerManager;
	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;

	public EmployerServiceTest() {
		this.employerManager = Mockito.mock(EmployerManager.class);
		this.authenticationManager = Mockito.mock(AuthenticationManager.class);
		this.userRepository =Mockito.mock(UserRepository.class);
	}

	@Test
	public void login(){
		UserDTO dto=new UserDTO("8fateme8","123456","fatemetorkzaban@gmail.com");
		employerManager.login(dto);
		JwtResponse jwt = authenticationManager.authenticate(dto.getUsername(), dto.getPassword());
		Assert.assertNull(jwt);
		User user =userRepository.findByUsername(dto.getUsername());
		Assert.assertNull(user);
	}

	@Test
	public void register(){
		UserDTO dto=new UserDTO("8fateme8","123456","fatemetorkzaban@gmail.com");
		employerManager.register(dto);
		User user =userRepository.findByUsername(dto.getUsername());
		Assert.assertNull(user);
	}

	@Test
	public void getOne(){
		Long jobId =new Random().nextLong();
		JobDomain jobDomain = employerManager.getOne(jobId);
		Assert.assertNull(jobDomain);
	}
}
