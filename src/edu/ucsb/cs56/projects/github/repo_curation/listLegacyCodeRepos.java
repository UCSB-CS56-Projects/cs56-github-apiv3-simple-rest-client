package edu.ucsb.cs56.projects.github.repo_curation;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import java.io.*;

import java.util.Collection;

public class listLegacyCodeRepos{
        public static void main(String[] args) {
                try{
                        Collection<GHRepository> lst = GitHub.connect().getUser("UCSB-CS56-Projects").getRepositories().values();
                        for (GHRepository r : lst) {
                                System.out.println("Name of repo: " + r.getName());
				
                        }
                        System.out.println("Number of repos: " + lst.size());
                }catch(IOException e){
                        e.printStackTrace();
                }
        }
}                   
