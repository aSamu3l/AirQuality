# AirQuality

This program is designed to function based on POST requests obtained from Air Sensor (made with a ESP32). The graphical interface is used solely for viewing the Air Quality.

JAVA server + database + evaluation summary interface


## Prerequisites

- Java 17
- Maven
- A MariaDB/MySQL database

## Configuration

1. Clone the repository:
    ```sh
    git clone https://github.com/aSamu3l/airquality.git
    cd AirQuality
    ```

2. Configure the database:
    - Create a MariaDB database named `air`.
    - Update the database credentials in the [application.properties](src/main/resources/application.properties) file:
        ```properties
        spring.datasource.url = jdbc:mariadb://localhost:3306/air
        spring.datasource.username = <your-username>
        spring.datasource.password = <your-password>
        ```

3. Generate an API token and update it in the [application.properties](src/main/resources/application.properties) file:
    ```properties
    api.token=your_generated_token
    ```

## Build and Run

### Windows

1. Build the project with Maven:
    ```sh
    ./mvnw clean install
    ```

2. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

### Linux

1. Build the project with Maven:
    ```sh
    mvn package
    ```

2. Run the application:
    ```sh
    java -jar ./airquality-0.0.1-SNAPSHOT.jar --spring.config.location=file:./application.properties
    ```

## Usage

### API Endpoints

- **Add a measurement**
    ```http
    POST /add
    ```
    - Headers:
        - `Authorization: your_generated_token`
    - Body (JSON):
        ```json
        {
            "room": "room1",
            "umid": "34.2",
            "temp": "25.5",
            "co2": "476"
        }
        ```
### Web Interface Endpoints

- **View today measurements**
    ```http
    GET /
    ```

- **View today measurements by room**
    ```http
    GET /?room=<room_name>
    ```

- **View all measurements**
    ```http
    GET /all
    ```

- **View all measurements by room**
    ```http
    GET /?room=<room_name>
    ```

### Web Interface

- Access the web interface to view the measurements:
    ```
    http://localhost:8080/
    ```
- You can change the port by updating the `server.port` property in the [application.properties](src/main/resources/application.properties) file:
    ```properties
    server.port=8080
    ```

## License

This project is licensed under the Apache-2.0 license. See the [LICENSE](LICENSE) file for details.