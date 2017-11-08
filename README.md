Github Repo Curation

* Use kohsuke API to put together a database of cs56 student's github repo's


Old README, left for now:

# You First need to understand:

* The Github Restful API: https://developer.github.com/v3/
* How to work with JSON in Java 
 * http://www.oracle.com/technetwork/articles/java/json-1973242.html 
 * https://jsonp.java.net/
 * https://json-processing-spec.java.net/nonav/releases/1.0/fcs/javadocs/index.html
* OAuth Tokens: (explained more below)

# Creating OAuth tokens

You will need to manually create a subdirectory of the main repo
directory called "tokens", and in that file, create a text file
containing an OAuth token.  The next section describes how:



OAuth tokens are strings in hex that can be used in place of a
username/password to authenticate to Github.  They look like this
(this isn't a real one):

 8cb9d3cc3dd33f457f06f94835bc9c11a748c06d


For instructions on how to create an OAuth token, go to:

https://help.github.com/articles/creating-an-access-token-for-command-line-use/

This explains how to generate the token.

You want to create a token with the privilege level needed.

I suggest the following names, which are assumed in the example code:

* tokens/PublicOnly.txt  only read privileges on public repositories and resources
* tokens/ReadOnly.txt  only read privileges, but includes private repos, team memberships, etc.  It has all the privileges to "see" everything, but cannot make changes to anything.
* tokens/MostPrivileges.txt  all privileges EXCEPT the most dangerous ones: keys, hooks and deleting repos.

#common problems

If you run into an issue where it's not returning the whole repo list, that's because github automatically sets it to 30. you need to override this like so:

$ curl 'https://api.github.com/user/repos?page=2&per_page=100'

# Things we want for each pull request

"url"
"title"
"user" { "login" }
"body" 

