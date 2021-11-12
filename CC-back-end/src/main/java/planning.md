T8 Capstone Progress/Timeline

11/1/2021 - Monday

Set up git repository & add in all files

Java (API), React App (UI), MySQL (tables, schema & data creation files, production & testing)

Design database schema (tables)

Set up database (write out DB code & such)

Set up API files & Spring Annotations

Begin to research into Tailwind CSS Styling Framework

11/2/2021- Tuesday

Decide first slice to work on collectively

Decided to work back to front on Campground

Start coding first slice

Campground Repo & tests → Service & tests → Controller & Mappers

Fixed up DB problems

Testing

Started Service Testing

Set up Repo Testing & DB known good state

DB known good state – lots of trouble with database and parent/child relationships blocking set_known_good_state() fxn from working properly – fixed

Repo deleteById needs to account for deleting campsites as well (?)

11/3/2021 - Wednesday

Complete all but one slice’s back end (code & testing)

CG repository delete() fix – parent/child dependencies, delete campsites & reservations as well in one sweep or do them separately? Make failsafe for no crashing in the event you can’t delete?

Start other back end slices (campsite, reservation, camper)

Campsite and camper are done

TBD reservation layer

11/4/2021 - Thursday

Almost finished the minimal viable product back end

Progress on the UI

11/5/2021 - Friday

Finish service testing and controller by lunch

Campground’s front end up and running by EOD

Have login page, signup page, home page finalized

Begin to look at Google Maps API

Back end:

Most crud aspect are functioning properly

(stuff we still need to do on back end)

TODO:

User table in database?

When signing up, user info is saved.

Front end auth is validated using user table



Front end:

Page access and go back completed

TODO:

complete implementation of login functionality

Campground/campsite page setup (separate components)

Map and calendar API



Weekend (11/6/2021 - 11/7/2021)

Aim to have mapping API figured out by Monday 2

11/8/2021 - Monday 2

Goal for EOD: Mapping API up and running

MAPPING API – KATY

FINISH UP WHOLE BACK END – THOMAS

WRITING JS API – COMMUNICATION BETWEEN FRONT AND BACK END PIECES – ROWAN

Get login up and running w/ new DB users

If not, talk to corbin Tuesday AM

11/9/2021 - Tuesday 2

Front end

Login – ask Corbin

Sign up – text not showing up in input boxes (onChange?)

Mapping progress

Reservations page (design and button functionality w/ api fxns)

Skeletons for some features laid out last night

Back end

Done (?)

11/10/2021 - Wednesday 2

Create README file with where everything can be found

Pages

View locations for all roles – necessary

Styling of some of the pages

Mapping API – markers being laid down

11/11/2021 - Thursday 2

Fix reservation findByCampsiteId problem - Rowan

Mapping Marker needs to be done

Campsite cards afterwards once campground is set

Update & Delete profile/user for USER privileges only – SignUp Page

Admin can change user role only - database

Practice presentation

Deployment once everything’s done – optional???

11/12/2021 - Friday 2

Presentation day

Page Break




Plan – pages left to finish

Admin

View locations (with or without update/delete options)

CampgroundsList.js?

Review reservations (view[needs formatting], update, delete)

By campground/site? All?

Review campers (view, update(?), delete(?))

User

View, update & delete own account from Profile Page - CamperProfile

View locations

If logged in – make reservation @ specific campground & campsite – design and mapping implementation on Campgrounds.js

Reservations page needs more design / implementations

Check for duplicate form

View current user’s existing reservations

Update & delete those

Should route to personal profile when you click on a DIV containing profile pic + username under navbar

No account

View locations

Or redirect to sign up if click make reservation button

MAPPING API

Pins working, but still needs more functionality...

AWS Deployment (video)

Presentation (see other old presentations for this)

HELP

Mapping api

Reservation form

camping

Todo

Slides

Lessons learned (challenges slide), things we did well

Split demo talking points into 3 user stories – one person per user story

Demo after intro & challenges afterwards – end on high note

Other

Make README file

Check over deliverables (tasks) in github repo

Split up talking points (slides & demo both)

Talk over demo stories in first person – not 2nd or 3rd person  