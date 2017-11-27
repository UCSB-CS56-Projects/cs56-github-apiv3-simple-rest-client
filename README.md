Github Repo Curation
Yossi Hertzberg and Vamsi Kalidindi 11/27/2017

* Use kohsuke API to put together a database of cs56 student's github repo's

To run:
* Type "gradle run" from root directory

What's working now:
* Able to list the names of all repos in the UCSB-CS56-F17 github account (and for any other account necessary)
* Able to list names of all members in an organization
* Able to list issue counts for each repo in the given github account
* Moved from ant to gradle
* Got kohsuke api working to grab the info about the given github account
* Able to list date of last commit for each repo's root

To remember:
* Need to include package name in all files (caused annoying error for a while)
* Can only get member names for org who has publicly visible members
* When listing member names of org, our program will try to output the actual name of the user. If the user did not specify name on github account, it prints their github id instead.
* Date of list commit is the date for the original root repo, not the forked version. Will only update if the forked repo gets merged to root.
