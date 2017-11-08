package edu.ucsb.cs56.projects.github.repo_curation;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import java.io.*;

import java.util.Collection;

public class testAPILib{
	public static void main(String[] args) {
		try{
    			Collection<GHRepository> lst = GitHub.connect().getUser("yossiyossi").getRepositories().values();
    			for (GHRepository r : lst) {
       				System.out.println(r.getName());
   			}
    			System.out.println(lst.size());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
