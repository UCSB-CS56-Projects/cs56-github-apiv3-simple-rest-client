Github Repo Curation

* Use kohsuke API to put together a database of cs56 student's github repo's

To run:
* Type "gradle run" from root directory

What's working now:
* Able to list the names of all repos in the UCSB-CS56-F17 github account (and for any other account necessary)
* Able to list names of all members in an organization
* Able to list issue counts for each repo in the given github account
* Moved from ant to gradle
* Got kohsuke api working to grab the info about the given github account


To remember:
* Need to include package name in all files (caused annoying error for a while)
* Can only get member names for org who has publicly visible members

ToDo:
* Get date of last commit for each repo
* Look into bug where some github user names shown as "null." Possibly due to settings of the individual users, because it currently works on some users but not on others.
