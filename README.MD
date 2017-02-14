# README #

This Android application is using the public github API: https://api.github.com/repositories

The first 20 repositories are shown inside RecyclerView's cards. The name of the author, his/her picture, the name of the repository and the first 15 words from the description.  
When the user clicks on one of the cards, the details of the repository are shown in a new Activity. The number of "stargazers", 
"forks", "watchers" and "open_issues". 

The application is using the followings: RecyclerView, CardView, Activity, Volley network library, Picasso library. The information is passed to the new Activity due to the fact that the model is a Parcelable.

Demo:

![alternate text](https://github.com/OctavianIonel/VolleyRecyclerViewParcelable/blob/master/VolleyRecyclerViewParcelable.gif)

In order to test this project, all you have to do is to clone it.

Enjoy!

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
