
# WalleeAssessment

This project is an Android Application used in the evaluation process for Wallee Android position. It was build using Kotlin and Jetpack Compose

# Main Libraries Used

Jetpack Compose, Hilt, Retrofit

# How to run

To set up and run the project locally:

1) Clone the repository:

    git clone https://github.com/kourounisgiorgos/WalleeAssessment.git

2) Open the project: Launch Android Studio and select "Open an existing Android Studio project." 

3) Navigate to the cloned repository and open it.

4) Build the project: Click on "Build" in the menu bar and select "Make Project" to compile the code and download necessary dependencies.

5) Run the application: Connect an Android device or start an emulator. Click on the "Run" button and select the target device to install and launch the app.

# Architecture Explanation

Model: Represents the data layer, responsible for managing data sources and business logic.

View: The UI layer, which displays data and forwards user interactions to the ViewModel.

ViewModel: Acts as an intermediary between the Model and the View, providing data streams to the View and handling user commands.

# Usage

Upon launching the application, users can interact with the UI to type in an amount and continue to the receipt screen. 

It handles user input and updates the UI accordingly.

It calls an endpoint to retrieve receipt data and display it in a view.
