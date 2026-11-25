# Cybersoft UI Automation Testing Framework

Dự án kiểm thử tự động giao diện người dùng (UI Automation Testing) cho hệ thống **Cybersoft Demo (`https://cybersoft.edu.vn`)**, được xây dựng theo mô hình thiết kế **Page Object Model (POM)** kết hợp **Data-Driven Configuration**, ghi nhật ký chi tiết và xuất báo cáo trực quan bằng **Allure Report**.

---

## 🛠 Công nghệ sử dụng (Tech Stack)

* **Ngôn ngữ lập trình:** Java (JDK 21)
* **Công cụ quản lý dự án & Build:** Gradle
* **Automation Framework:** Selenium WebDriver (`4.38.0`)
* **Test Framework:** TestNG (`7.11.0`)
* **Báo cáo kiểm thử (Reporting):** Allure Report (`2.35.1`) + AspectJ Weaver
* **Ghi nhận nhật ký (Logging):** SLF4J (`2.0.17`) & Logback (`1.5.18`)

---

## 📂 Cấu trúc thư mục dự án

```text
cybersoft-automation/
├── build.gradle                         # Cấu hình dependencies, Gradle tasks và Allure plugin
├── src
│   ├── main
│   │   ├── java                         # Thư viện lõi (BasePage, DriverManager, WaitUtils, ConfigReader...)
│   │   └── resources
│   │       ├── config.properties        # Cấu hình môi trường (base.url, browser, headless, timeout)
│   │       └── test-data.properties     # Dữ liệu đầu vào phục vụ kiểm thử (tài khoản, thông báo...)
│   └── test
│       ├── java
│       │   └── com.automation
│       │       ├── base                 # BaseTest (khởi tạo/đóng trình duyệt, gắn TestNG Listeners)
│       │       ├── listeners            # AllureStepListener (chụp ảnh khi step fail), TestListener (log trạng thái)
│       │       ├── pages                # Các lớp Page Object đại diện cho từng màn hình chức năng
│       │       ├── tests                # Các lớp kịch bản kiểm thử (TestNG @Test)
│       │       └── utils                # LogUtils (SLF4J + Allure step), ScreenshotUtils
│       └── resources
│           ├── META-INF
│           │   └── services
│           │       └── io.qameta.allure.listener.StepLifecycleListener  # Đăng ký Allure Step Listener
│           └── logback-test.xml         # Cấu hình định dạng xuất log ra Console và File
└── build                                # Thư mục tự sinh chứa kết quả chạy test (đã bỏ qua trong .gitignore)
    ├── logs
    │   └── test-execution.log           # File lưu toàn bộ nhật ký thao tác và trạng thái chạy test
    └── reports
        └── allure-report                # Báo cáo HTML trực quan của Allure
```

---

## ✨ Tính năng nổi bật

1. **Tách biệt cấu hình & Dữ liệu kiểm thử (`src/main/resources`):**
    * Dễ dàng thay đổi URL môi trường, trình duyệt (`chrome`), chế độ chạy ngầm (`headless=true/false`) và thời gian chờ (`timeout=10`) trong file `config.properties` mà không cần sửa code.
    * Quản lý tập trung dữ liệu đầu vào tại `test-data.properties`.
2. **Page Object Model (POM) & Thread-Safe:**
    * Tách biệt rõ ràng giữa thành phần giao diện (`pages`) và kịch bản kiểm thử (`tests`), quản lý `WebDriver` an toàn qua `ThreadLocal`.
3. **Báo cáo trực quan tự động (Allure Report):**
    * Tự động dọn dẹp dữ liệu kết quả cũ trước mỗi lần chạy mới.
    * Phân cấp rõ ràng từng hành động nghiệp vụ (`@Step`) và thao tác chi tiết bên trong.
4. **Tự động chụp ảnh màn hình khi lỗi (Auto Screenshot on Step Failure):**
    * Tích hợp `StepLifecycleListener` của Allure để bắt chính xác thời điểm một `@Step` bị `FAILED` hoặc `BROKEN` và đính kèm ảnh chụp màn hình ngay bên trong step đó.
5. **Ghi log chi tiết & Bảo mật (Detailed Logging):**
    * Ghi nhận đầy đủ mốc thời gian, từng thao tác (`Click`, `Type`, `Get Text`) và trạng thái kết thúc (`PASS` / `FAIL` / `SKIP`) ra cả màn hình Console lẫn file `build/logs/test-execution.log`.
    * Tự động che (mask) dữ liệu nhạy cảm như mật khẩu (`******`) trong log và báo cáo.

---

## 🚀 Hướng dẫn cài đặt và chạy kiểm thử

### 1. Yêu cầu môi trường
* Đã cài đặt **Java JDK 17** trở lên.
* Đã cài đặt trình duyệt **Google Chrome** phiên bản mới nhất.

### 2. Chạy toàn bộ bộ kiểm thử (Test Suite)
Mở Terminal tại thư mục gốc của dự án và chạy lệnh:

* **Trên macOS / Linux:**
  ```bash
  ./gradlew clean test
  ```
* **Trên Windows:**
  ```cmd
  gradlew.bat clean test
  ```

### 3. Xem báo cáo Allure Report & File Log
* **Xem báo cáo HTML (tự động mở trên trình duyệt):**
    * **macOS / Linux:** `./gradlew allureServe`
    * **Windows:** `gradlew.bat allureServe`
      *(Hoặc mở trực tiếp file báo cáo đã được sinh sẵn sau khi chạy test tại: `build/reports/allure-report/allureReport/index.html`)*.
* **Xem nhật ký thực thi chi tiết (Execution Log):**
    * Mở file tại đường dẫn: `build/logs/test-execution.log`


---------------------------------------------------------------

# Cybersoft UI Automation Testing Framework

An end-to-end UI Automation Testing framework built for **Cybersoft Demo (`https://cybersoft.edu.vn`)**, following the **Page Object Model (POM)** design pattern combined with **Data-Driven Configuration**, detailed execution logging, and visual reporting via **Allure Report**.

---

## 🛠 Tech Stack

* **Programming Language:** Java (JDK 21)
* **Build & Dependency Management:** Gradle
* **Automation Framework:** Selenium WebDriver (`4.38.0`)
* **Test Framework:** TestNG (`7.11.0`)
* **Test Reporting:** Allure Report (`2.35.1`) + AspectJ Weaver
* **Logging:** SLF4J (`2.0.17`) & Logback (`1.5.18`)

---

## 📂 Project Structure

```text
cybersoft-automation/
├── build.gradle                         # Dependencies, Gradle tasks, and Allure plugin configuration
├── src
│   ├── main
│   │   ├── java                         # Core utilities (BasePage, DriverManager, WaitUtils, ConfigReader...)
│   │   └── resources
│   │       ├── config.properties        # Environment settings (base.url, browser, headless, timeout)
│   │       └── test-data.properties     # Centralized test input data (credentials, expected messages...)
│   └── test
│       ├── java
│       │   └── com.automation
│       │       ├── base                 # BaseTest (browser setup/teardown, TestNG Listeners registration)
│       │       ├── listeners            # AllureStepListener (auto-screenshot on step fail), TestListener (status logs)
│       │       ├── pages                # Page Object classes representing application screens
│       │       ├── tests                # TestNG test suites and test scenarios (@Test)
│       │       └── utils                # LogUtils (SLF4J + Allure step), ScreenshotUtils
│       └── resources
│           ├── META-INF
│           │   └── services
│           │       └── io.qameta.allure.listener.StepLifecycleListener  # SPI registration for Allure Step Listener
│           └── logback-test.xml         # Console and file logging format configuration
└── build                                # Auto-generated test outputs (ignored in .gitignore)
    ├── logs
    │   └── test-execution.log           # Detailed step-by-step execution and status log file
    └── reports
        └── allure-report                # Interactive Allure HTML report
```

---

## ✨ Key Features

1. **Externalized Configuration & Test Data (`src/main/resources`):**
    * Easily switch target URLs, browsers (`chrome`), headless execution (`headless=true/false`), and explicit wait timeouts (`timeout=10`) in `config.properties` without modifying source code.
    * Manage test data centrally via `test-data.properties`.
2. **Page Object Model (POM) & Thread-Safe Execution:**
    * Clean separation between UI locators/actions (`pages`) and test assertions (`tests`), utilizing `ThreadLocal` in `DriverManager` for safe parallel execution.
3. **Interactive Automated Reporting (Allure Report):**
    * Automatically cleans stale test results prior to each test run.
    * Hierarchically organizes business-level actions (`@Step`) and granular UI interactions.
4. **Automatic Screenshot Attachment on Step Failure:**
    * Leverages Allure's `StepLifecycleListener` to capture screenshots at the exact moment a `@Step` transitions to `FAILED` or `BROKEN`, attaching the image directly inside the failed step.
5. **Detailed & Secure Logging:**
    * Logs timestamps, granular UI actions (`Click`, `Type`, `Get Text`), and test execution statuses (`PASS` / `FAIL` / `SKIP`) to both the console and `build/logs/test-execution.log`.
    * Automatically masks sensitive inputs such as passwords (`******`) in logs and reports.

---

## 🚀 Getting Started

### 1. Prerequisites
* **Java JDK 17** or higher installed.
* **Google Chrome** browser (latest version) installed.

### 2. Run the Test Suite
Open a terminal at the project root directory and run:

* **macOS / Linux:**
  ```bash
  ./gradlew clean test
  ```
* **Windows:**
  ```cmd
  gradlew.bat clean test
  ```

### 3. View Allure Report & Execution Logs
* **Launch interactive Allure HTML Report in browser:**
    * **macOS / Linux:** `./gradlew allureServe`
    * **Windows:** `gradlew.bat allureServe`
      *(Alternatively, open the generated static report at `build/reports/allure-report/allureReport/index.html`)*.
* **Inspect Execution Logs:**
    * Open the log file located at `build/logs/test-execution.log`.
