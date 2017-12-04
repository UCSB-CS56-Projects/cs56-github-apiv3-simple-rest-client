package edu.ucsb.cs56.projects.github.repo_curation;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHUser;
import java.io.*;

import java.util.Collection;

/**
	Class to pull info about github account to help grade cs56 projects

	@author Yossi Hertzberg
	@author Vamsi Kalidindi

*/

public class listLegacyCodeRepos{
        /** main method to get repo info through calls to helper methods
	    @param args not used
	 
	*/
	public static void main(String[] args) {
                String user = "UCSB-CS56-Projects";

		printAllRepoInfo(user);
        	printNumberOfRepos(user);
		
		String org = "UCSB-CS56-F17";
		printAllMembers(org);
		printNumMembers(org);	
	
	}

	/**printNumMembers prints the number of members for a given github organization.Members need to be public on the org for this to work.
	 @param user is the name of a github organization
	 
	*/

	public static void printNumMembers(String user){
		   try{
                        GHOrganization org = GitHub.connect().getOrganization(user);
                        Collection<GHUser> lst = org.getMembers();
                        System.out.println("Number of members: " + lst.size());

                } catch(IOException e){
                        e.printStackTrace();
                }	
	}

	/**printAllMembers prints all the names of members of a given github organization.If the member does not provide a name, then his/her github login id is printed.
	   @param user is the name of a github organization
		
	*/
	public static void printAllMembers(String user){
		try{
			GHOrganization org = GitHub.connect().getOrganization(user);
			Collection<GHUser> lst = org.getMembers();
			for (GHUser u : lst){
				String name = u.getName();
				if(name == null){
					name = u.getLogin();
				}
				System.out.println(user + " has member: " + name);
			}

		} catch(IOException e){
			e.printStackTrace();
		}
	}

	/**printAllRepoInfo prints the name and issue count of all repo's of a given github user's account
	   @param user is the name of a github user
	 
	*/
	public static void printAllRepoInfo(String user){
		try{
                        Collection<GHRepository> lst = GitHub.connect().getUser(user).getRepositories().values();
                        for (GHRepository r : lst) {
                                System.out.println("Name of repo: " + r.getName());
				System.out.println("\tIssue count: " + r.getOpenIssueCount());
				System.out.println("\tDate of last commit to master: " + r.getUpdatedAt());	
                        
			}
                }catch(IOException e){
                        e.printStackTrace();
                }

	}
	
	/**printNumberOfRepos prints the number of repo's in a given user's account
	   @param user is the name of the github user
	 
	*/

	public static void printNumberOfRepos(String user){
		try{
                        Collection<GHRepository> lst = GitHub.connect().getUser("UCSB-CS56-Projects").getRepositories().values();
                        System.out.println("Number of repos: " + lst.size());
                }catch(IOException e){
                        e.printStackTrace();
                }

	}
}                   
