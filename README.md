# ソーシャルネットワークシステム

## 概要
このソーシャルネットワークシステムは、ユーザーが他のユーザーとつながり、メッセージを送信し、投稿を共有するためのプラットフォームです。主な機能には、ユーザー登録・認証、プロフィール管理、友達リクエスト、投稿作成・表示、コメント、メッセージングなどがあります。

## API設計

### ユーザー関連
- **POST /api/register**: ユーザー登録
- **POST /api/login**: ユーザー認証
- **GET /api/users/{id}**: ユーザー情報取得
- **PUT /api/users/{id}**: ユーザー情報更新

### 友達関連
- **POST /api/friends/request**: 友達リクエスト送信
- **POST /api/friends/accept**: 友達リクエスト承認
- **GET /api/friends**: 友達リスト取得

### 投稿関連
- **POST /api/posts**: 新規投稿作成
- **GET /api/posts**: 投稿一覧取得
- **GET /api/posts/{id}**: 特定の投稿取得
- **PUT /api/posts/{id}**: 投稿更新
- **DELETE /api/posts/{id}**: 投稿削除

### コメント関連
- **POST /api/posts/{postId}/comments**: コメント追加
- **GET /api/posts/{postId}/comments**: コメント一覧取得

### メッセージ関連
- **POST /api/messages**: メッセージ送信
- **GET /api/messages**: メッセージ一覧取得

## DB設計

### users テーブル
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    profile_picture VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### friends テーブル
```sql
CREATE TABLE friends (
    user_id INT REFERENCES users(id),
    friend_id INT REFERENCES users(id),
    status VARCHAR(20) NOT NULL, -- 'pending', 'accepted', 'rejected'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, friend_id)
);
```

### posts テーブル
```sql
CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### comments テーブル
```sql
CREATE TABLE comments (
    id SERIAL PRIMARY KEY,
    post_id INT REFERENCES posts(id),
    user_id INT REFERENCES users(id),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### messages テーブル
```sql
CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    sender_id INT REFERENCES users(id),
    receiver_id INT REFERENCES users(id),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## セットアップと実行

### Spring Boot アプリケーションのセットアップと実行
1. プロジェクトのクローンを作成します。
   ```bash
   git clone https://github.com/naka-sho/proto-sns.git
   cd proto-sns
   ```

2. 必要な依存関係をインストールします。
   ```bash
   ./mvnw install
   ```

3. アプリケーションを実行します。
   ```bash
   ./mvnw spring-boot:run
   ```

### MySQL と MyBatis の設定
1. MySQL をインストールし、データベースを作成します。
   ```sql
   CREATE DATABASE sns;
   ```

2. `src/main/resources/application.properties` ファイルを編集し、データベース接続情報を設定します。
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/sns
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   mybatis.mapper-locations=classpath:mapper/*.xml
   ```

3. MyBatis のマッパーファイルを作成し、`src/main/resources/mapper` ディレクトリに配置します。
