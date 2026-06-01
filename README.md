# Dependency Template Library

基于 JitPack 的 Android 依赖库模板项目。

## 快速开始

### 1. 全局搜索替换清单

使用本模板创建新项目时，请按以下顺序执行全局搜索替换：

| 步骤 | 搜索关键词 | 替换为 | 说明 |
|------|-----------|--------|------|
| 1 | `com.dep.template` | `你的包名` | 所有源码中的包名 |
| 2 | `dep-template-lib` | `你的项目名` | 项目名称和 artifactId |
| 3 | `dep_template_lib` | `你_的_项目_名` | JitPack 中的 artifact ID |
| 4 | `[UserName]` | `你的 GitHub 用户名` | 发布配置中的用户名 |
| 5 | `your_email@example.com` | `你的邮箱` | 开发者联系方式 |

### 2. 自定义项目配置

#### 修改项目名称

编辑 [settings.gradle](file:///d:/StudioProject_learning/dep-template-lib/settings.gradle)：

```gradle
rootProject.name = "你的项目名"
```

#### 修改版本信息

编辑 [build.gradle](file:///d:/StudioProject_learning/dep-template-lib/build.gradle)：

```gradle
defaultConfig {
    versionCode 1
    versionName "1.0.0"
}
```

编辑 [gradle.properties](file:///d:/StudioProject_learning/dep-template-lib/gradle.properties)：

```properties
VERSION_NAME=1.0.0
VERSION_CODE=1
```

#### 修改依赖版本

编辑 [build.gradle](file:///d:/StudioProject_learning/dep-template-lib/build.gradle) 中的 `dependencies` 块，按需调整版本号或添加/移除依赖。

## 项目结构

```
├── src/main/
│   ├── java/com/dep/template/
│   │   ├── module/
│   │   │   └── LibTemplate.kt      # 库入口初始化类
│   │   └── utils/
│   │       ├── EasyStringUtils.kt   # 字符串工具类
│   │       └── SampleUtil.kt        # 示例工具类
│   ├── res/values/
│   │   ├── colors.xml
│   │   └── themes.xml
│   └── AndroidManifest.xml
├── build.gradle                     # 模块构建配置
├── gradle.properties                # 发布配置
├── settings.gradle                  # 项目设置
├── jitpack.yml                      # JitPack 构建配置
├── proguard-rules.pro               # 混淆规则
└── consumer-rules.pro               # 消费者规则
```

## 通过 JitPack 发布和使用

### 发布步骤

1. **将代码推送到 GitHub**：
   ```bash
   git add .
   git commit -m "发布版本 1.0.0"
   git tag -a 1.0.0 -m "版本 1.0.0"
   git push origin main --tags
   ```

2. **JitPack 会自动构建**：
   - 访问 https://jitpack.io/#[UserName]/dep-template-lib
   - JitPack 会自动检测新标签并开始构建

3. **检查构建状态**：
   - 绿色表示构建成功
   - 点击 "Get it" 查看依赖配置

### 在其他项目中使用（通过 JitPack）

1. **添加 JitPack 仓库**（如果还没有）：
   ```gradle
   allprojects {
       repositories {
           maven { url 'https://jitpack.io' }
       }
   }
   ```

   或者新版 Gradle 在 `settings.gradle` 中配置：
   ```gradle
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           google()
           mavenCentral()
           maven { url 'https://jitpack.io' }
       }
   }
   ```

2. **添加依赖**：
   ```gradle
   dependencies {
       implementation 'com.github.[UserName]:dep-template-lib:1.0.0'
   }
   ```

### 版本说明

- **使用具体版本号**：`1.0.0`（推荐）
- **使用最新提交**：`main-SNAPSHOT`（不推荐）
- **使用标签**：`1.0.0`（推荐）

## 本地测试发布

```bash
# 发布到本地 Maven 仓库
./gradlew build publishToMavenLocal
```

## 添加新功能

1. 在 `src/main/java/com/dep/template/` 目录下创建新的 Kotlin 文件
2. 实现你的功能
3. 更新版本号（在 `gradle.properties` 中修改 `VERSION_NAME`）
4. 创建新标签并推送到 GitHub

## JitPack 注意事项

1. **确保项目能正常构建**：JitPack 会在干净环境中构建
2. **使用正确的 group ID**：必须是 `com.github.用户名`
3. **添加必要的配置**：`jitpack.yml` 文件可帮助构建
4. **检查构建日志**：如果失败，查看 JitPack 的构建日志

## 版本管理

- 使用语义化版本控制（SemVer）
- 主版本号：不兼容的 API 变更
- 次版本号：向后兼容的功能性新增
- 修订号：向后兼容的问题修正
- 每次发布创建 Git 标签
