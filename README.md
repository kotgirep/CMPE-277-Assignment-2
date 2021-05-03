# CMPE-277-Assignment-2
#### Student Name: Pranjali Kotgire (014640379)
#### University Name: San Jose State University
#### App Screenshots:
 <img src="https://github.com/kotgirep/CMPE-277-Assignment-2/blob/main/MainScreen.png" width="250">
 
#### App screen shot of Scroll-View:

 <img src="https://github.com/kotgirep/CMPE-277-Assignment-2/blob/main/Scroll-View.png" width="450">
 
 <img src="https://github.com/kotgirep/CMPE-277-Assignment-2/blob/main/Scroll-view2.png" width="450">
 
 
 
#### Steps:

1. I fetched Weather data from OpenWeatherMap API.

2. I have used libraries like retrofit,mochi 
 `implementation "com.squareup.retrofit2:retrofit:$version_retrofit"`
 `implementation "com.squareup.retrofit2:converter-scalars:$version_retrofit"`
 `implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'`

   Retrofit with Moshi Converter dependancy
  `implementation "com.squareup.retrofit2:converter-moshi:$version_retrofit"`
  `implementation 'com.google.android.gms:play-services-maps:17.0.0'`

   Moshi dependancy to parse json data
   `def version_moshi = "1.8.0"`
   `implementation "com.squareup.moshi:moshi:$version_moshi"`
   `implementation "com.squareup.moshi:moshi-kotlin:$version_moshi"`
   
  3. To Bind Data To appropriate view I have used Data Binding technique.
 
  4. I have applied gradient background via XML.

  5. In this assignment i have used constraint layout and applied to the element like textview, imageview and input field.

  6. In this assignment the application shows sunset,sunrise,min temprature, maximum temprature,pressure, windspeed, Current Temprature of a particular city.
  
  7. I am converting temprature from degree celcius to Farenheit 
  
  8. I have Added Scroll-view AS well where we can Rotate Screen and though data display doesnot change.
  9. 

