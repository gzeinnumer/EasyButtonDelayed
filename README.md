<pre>
<img src="https://github.com/gzeinnumer/NumberForm/blob/master/preview/example3.gif" width="300">
</pre>

<h1 align="center">
    EasyButtonDelayed
</h1>

<p align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.3-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Easy Delay TabLayout or Button.</p>
</p>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Tech stack and 3rd library](#tech-stack-and-3rd-library)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:EasyButtonDelayed:version'
}
```

---
# Feature List

- [x] [DelayButton](#DelayButton)
- [x] [DelayTabLayout](#DelayTabLayout)

#
#### DelayButton

Default Delay 2 second (2000)

```java
button.setOnClickListener(new DelayButton(button, new View.OnClickListener() {}));
```

```java
Button button = findViewById(R.id.btn);

button.setOnClickListener(new DelayButton(button, new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
    }
}));
```

Custom Delay 1 second (1000)

```java
int delay = 1000;
button.setOnClickListener(new DelayButton(button, new View.OnClickListener() {}, delay));
```

#
#### DelayTabLayout

Default Delay 2 second (2000)

```java
tabLayout.addOnTabSelectedListener(new DelayTabLayout(tabLayout, new TabLayout.OnTabSelectedListener() {}));
```

```java
TabLayout tabLayout = findViewById(R.id.tab_layout);

tabLayout.addOnTabSelectedListener(new DelayTabLayout(tabLayout, new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Toast.makeText(getApplicationContext(), "test aja", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}
}));
```

Custom Delay 1 second (1000)

```java
int delay = 1000;
tabLayout.addOnTabSelectedListener(new DelayTabLayout(tabLayout, new TabLayout.OnTabSelectedListener() {}, delay));
```

---
# Example Code/App

[MainActivity.java](https://github.com/gzeinnumer/EasyButtonDelayed/blob/master/app/src/main/java/com/gzeinnumer/easybuttondelayed/MainActivity.java)
[activity_main.xml](https://github.com/gzeinnumer/EasyButtonDelayed/blob/master/app/src/main/res/layout/activity_main.xml)

---
# Version
- **1.0.3**
  - First Release

---
# Contribution
You can sent your constribution to `branch` `open-pull`.

### Fore More [All My Library](https://github.com/gzeinnumer#my-library-list)

---

```
Copyright 2022 M. Fadli Zein
```