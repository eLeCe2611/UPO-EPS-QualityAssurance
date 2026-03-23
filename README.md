# 💻 Automated Testing Project for the Escuela Politécnica Superior (UPO) Web Page 🏫

📚 **Course:** Calidad  
👥 **Team Members:** Grupo #02  
- Carmona Berdugo, Luis
- López Pilares, Carlos
- Polo Suárez, Pablo
- Remesal Banda, Alejandro
- Romero Corredero, Diego
- Sánchez Troncoso, Pablo

---

## 🔍 Project Overview

The Escuela Politécnica Superior of Universidad Pablo de Olavide requires a thorough verification of its website to ensure integrity, functionality, and overall quality. This project implements both **functional** and **non-functional automated tests** to evaluate the [Escuela Politécnica Superior (UPO)](https://www.upo.es/escuela-politecnica-superior/es/) site.

The primary objective is to provide a structured and automated approach for quality assurance, covering aspects such as usability, performance, security, accessibility, and cross-browser compatibility.

---

## 📂 Project Structure

- **`jmeter-tests/`**: Non-functional tests without profiling using Apache JMeter
- **`maven-jmeter-tests/`**: Non-functional tests with profiling (Maven + JMeter)
- **`nmap-tests/`**: Security tests with Nmap
- **`selenium-tests/`**: Functional tests with Selenium + TestNG
- **`eclipse-linter-config.xml`**: Eclipse code style guide

---

## 🛠️ Technologies Used

The project leverages a diverse set of tools and frameworks to cover all testing dimensions:

- ⚙️ **Programming & Automation:** [Java](https://www.java.com/es/), [Apache Maven](https://maven.apache.org/), [Eclipse IDE](https://eclipseide.org/), [TestNG](https://testng.org/)
- 🧪 **Functional Testing:** [Selenium](https://www.selenium.dev/)
- 🚀 **Performance & Load Testing:** [Apache JMeter](https://jmeter.apache.org/)
- 🔒 **Security Testing:** [Nmap](https://nmap.org/), [Qualys SSL Labs](https://www.ssllabs.com/ssltest/)
- ♿ **Accessibility Testing:** [Wave](https://wave.webaim.org/)
- 🐞**Exploratory Testing:** [Bug Magnet](https://bugmagnet.org/)
- 🔗 **Link Integrity:** [Deadlink Checker](https://www.deadlinkchecker.com/)
- 🌐 **Cross-Browser & Device Testing:** [BrowserStack](https://www.browserstack.com/)

More info at the **[wiki of the project](https://github.com/eLeCe2611/UPO-EPS-QualityAssurance/wiki/Wiki)**.  

---
## ✏️ Code Style Guidelines

This project follows a standardized code style to ensure consistency, readability, and maintainability:

- **IDE:** Eclipse  
- **Configuration:** `eclipse-linter-config.xml`  
- **Coding Conventions:** Standard Java naming conventions.  

### 📄 File Naming Conventions

- All files must use **lowercase, hyphen-separated names (kebab-case)**, unless a language- or framework-specific convention applies (for example, PascalCase in Java).  
- **Test directories** must follow the naming pattern: `<technology>-tests/`.  
- **Each test file** must be named using the pattern: `test-<test-name>.*`, unless an alternative convention is required by the language or framework.  

---
