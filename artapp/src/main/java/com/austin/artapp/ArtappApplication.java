package com.austin.artapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.austin.artapp.services.FilesService;

@SpringBootApplication
public class ArtappApplication implements CommandLineRunner {

	@Resource
	FilesService filesService;
	
	public static void main(String[] args) {
		SpringApplication.run(ArtappApplication.class, args);
	}
	
	  @Override
	  public void run(String... arg) throws Exception {
	    filesService.init();
	  }

}
