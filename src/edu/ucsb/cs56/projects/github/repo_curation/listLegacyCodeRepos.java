package edu.ucsb.cs56.projects.github.repo_curation;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHUser;
import java.io.*;

import java.util.Collection;

public class listLegacyCodeRepos{
        public static void main(String[] args) {
                
		printAllRepoNames("UCSB-CS56-Projects");
        	printNumberOfRepos("UCSB-CS56-Projects");
		printAllMembers("UCSB-CS56-F17");	
	
	}

	public static void printAllMembers(String user){
		try{
			GHOrganization org = GitHub.connect().getOrganization(user);
			Collection<GHUser> lst = org.getMembers();
			for (GHUser u : lst){
				System.out.println(user + " has member: " + u.getName());
			}

		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void printAllRepoNames(String user){
		try{
                        Collection<GHRepository> lst = GitHub.connect().getUser(user).getRepositories().values();
                        for (GHRepository r : lst) {
                                System.out.println("Name of repo: " + r.getName());

                        }
                       // System.out.println("Number of repos: " + lst.size());
                }catch(IOException e){
                        e.printStackTrace();
                }

	}

	public static void printNumberOfRepos(String user){
		try{
                        Collection<GHRepository> lst = GitHub.connect().getUser("UCSB-CS56-Projects").getRepositories().values();
                        System.out.println("Number of repos: " + lst.size());
                }catch(IOException e){
                        e.printStackTrace();
                }

	}
}                   
