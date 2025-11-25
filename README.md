# QuotationApp
Simple Android application that displays a list of quotations.  
Each item contains a quotation and the author's name.  
After clicking on any quotation, the app opens a second screen that shows the selected text in a larger, readable format.

## 📱 Features

- List of quotations loaded from a local text file (`assets/quotations.txt`)
- Clean and minimalistic UI based on **ConstraintLayout**
- Click handling on list items (RecyclerView)
- Dedicated detail screen for showing a selected quotation
- Smooth transitions between activities
- Fully written in Java
  
## 📂 Project Structure
```
app/
 ├── java/
 │    └── com.example.quotationapp/
 │         ├── MainActivity.java
 │         ├── QuoteDetailActivity.java
 │         ├── Quote.java
 │         └── QuoteAdapter.java
 ├── res/
 │    └── layout/
 │         ├── activity_main.xml
 │         ├── activity_quote_detail.xml
 │         └── item_quote.xml
 └── assets/
      └── quotations.txt
```

## 📦 How it works

 1. Loading data  
The app reads all quotations from `assets/quotations.txt` using `InputStream` and displays them in a `RecyclerView`.

 2. Selecting a quote  
Clicking any list item triggers an `Intent` that opens `QuoteDetailActivity` and passes the selected quote through `putExtra`.

 3. Detail view  
The second screen shows the full text of the quote and the author's name.


## 🛠 Technologies

- Java
- Android SDK
- RecyclerView
- ConstraintLayout
- Intent & Activity navigation


## 📸 Screenshots


<details>
  <summary>Show screenshots</summary>

  **Main screen**
  
  <img width="266" height="595" alt="image" src="https://github.com/user-attachments/assets/7b7ed083-17a7-4614-b75c-78ba15cc0be7" />

  **Detail screen**

  <img width="266" height="595" alt="image" src="https://github.com/user-attachments/assets/8bceaeb2-64f3-4b75-af3e-f3a8c8da6e2c" />

</details>




## 🚀 Running the project

1. Clone the repository
```bash
git clone https://github.com/userladyslav/QuotationApp.git















