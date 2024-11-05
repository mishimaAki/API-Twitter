# 🚧 編集中です！🚧

✅ タスク
- [x] PostgreSQLに登録したい型とSpringBootで登録した型が合っているか調べる（bigintとLongが対応しているか調べる）
- [x] ER図を完成させる
- [x] MavenのCIを動作させる
- [x] DBのカラム名をドメインに合わせる（具体性を持たせる）
<br>➡Entityでは各IDをidとしてコードの一貫性を保つ
<br>➡カラム名はスネークケースを用いて区別させる
<br>➡DTOファイルも統一する（今回は汎用的なため。DTOオブジェクトはJSONに対応するため、ほかにDTOを定義する場合は要件に合わせて使い分ける）
- [x] DBのカラム名と実際の変数名が異なって良いかを調べる➡プログラム内で統一されていれば🆗 挙動も正常
- [x] EntityのTweetからDTO(必要な情報のみをクライアントと送受信するためのオブジェクト)に変換する🗺️マッパーファイル🗺️を実装する（not 急務）
<br>➡現状不必要に思われるのでスキップ
- [x] CRUD処理のU(pdate)とD(elete)を実装する+指定された１つだけのツイートの取得も（優先度高め）
- [x] 自動でDBを作成させるか一旦悩む
<br>➡容量の都合+セキュリティの都合+非実践的な都合上、テスト用のインメモリDBのみ作成させる
- [x] 🙍 進行中 🙍 Dependency GraphのCIを実行できるようにする（要相談）
<br>➡ymlファイル内で定義していたPermission処理を削除したら解決。Githubレポジトリの設定より、yml内でのPermissionのほうが優先される。
- [x] カラム名がcreated_atになってしまうのを防ぐ（not 急務）
<br>➡ORMでは一般的らしい。
- [x] 各クラスの役割の解説を書く（最低限）
- [ ] エラー時のハンドリングシナリオを明確にする
- [ ] エラーハンドリングの設計時にフロントエンドのシナリオも考える
- [ ] PUTでの更新時に時刻を更新させるかを考慮する

🗺 ユーザーストーリーマップ（一部）

<img width="1000" alt="キャプチャ" src="https://github.com/user-attachments/assets/d4e52a61-521e-4f41-bf6c-236ccd15ae02">



## ⚙️ システム構成

- アーキテクチャ：クリーンアーキテクチャ、ドメイン駆動設計
- データベース：PostgreSQL 17rc1
- バックエンドフレームワーク：Spring Boot 3.3.3
- フロントエンド：Next.js（予定）Tailwind CSS（予定）
- CLI：Windows PowerShell

## 📃 詳細設計

### 🗺️ UML図の全体図（仮）

<img width="328" alt="キャプチャ" src="https://github.com/user-attachments/assets/d6eb1928-4d97-4a5b-a467-07ecf049e537">

#### 🔍 拡大図

<img width="200" alt="キャプチャ1" src="https://github.com/user-attachments/assets/08357c14-a487-409b-878d-4c025afb956a">

<img width="200" alt="キャプチャ3" src="https://github.com/user-attachments/assets/93db29cd-cb7e-4973-83b2-6878d47d4633">


### 👤➡💻 シーケンス図（仮）

<img width="160" alt="2313213" src="https://github.com/user-attachments/assets/43a353b7-4a5c-4931-87f7-1c24e34041da">

### 📈 ER図(仮)

<img width="218" alt="6666" src="https://github.com/user-attachments/assets/2bf14b94-53d8-4c4a-9893-3524e248a0a7">

<details>
  <summary>SQLへ実際に登録された情報</summary>

<img width="320" alt="55555" src="https://github.com/user-attachments/assets/0b880640-b7a0-4f36-bb25-63f8c9a11ff6">

</details>

## 🏗 事前準備

PostgreSQLを事前にインストールし、*twitter*という**DB**を作成

appilication.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/twitter //DB名はここに対応
spring.datasource.username=postgres
spring.datasource.password=root
```

propertiesに合わせてユーザー名と、ユーザーに対応するパスワードを入力

## 📋 実行結果

### 1.Postリクエストでの登録処理

まずは環境変数にリクエストするJSONを設定

```PowerShell
$body = @{
  content = "Hello, World!"
  } | ConvertTo-Json
```
<sub>パイプライン処理を用いてJSON形式に変換しています</sub>

curlの代わりにInvoke-RestMethodを用いてPostリクエストを送信
```PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/tweets" -Method Post -Body $body -ContentType "application/json"
```

#### 結果

<img width="300" alt="DB1 (2)" src="https://github.com/user-attachments/assets/ad3dd5a8-7a44-4c48-97c4-3cdc7b82a651">

JSONの内容を変えてもう一度Post
```PowerShell
$body = @{
  content ="Sup, Elon Musk!"
  } | ConvertTo-Json
```

```PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/tweets" -Method Post -Body $body -ContentType "application/json"
```

#### 結果

<img width="300" alt="DB2" src="https://github.com/user-attachments/assets/1088aa30-0b85-4380-84a5-49c44dfbf076">

### 2.Getリクエストでの呼び出し処理

-MethodにてGetを指定しリクエストを送信

```PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/tweets" -Method Get
```

#### 結果

<img width="300" alt="DB4" src="https://github.com/user-attachments/assets/0f5eb386-4bbe-4fd0-8d45-b1391988d8d2">

### 2.Getリクエストでの呼び出し処理

-MethodにてPutを指定しリクエストを送信

```PowerShell
$body = @{
  id = 2
  content ="Hello, World!"
  } | ConvertTo-Json  
```
<sub>同一のidが存在しなければ追加で保存されてしまうので注意</sub>

```PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/tweets" -Method PUT -Body $body -ContentType "application/json"
```

#### 結果

<img width="300" alt="キャプチャ" src="https://github.com/user-attachments/assets/56663a8d-79cf-405c-b3c0-00646eb802af">


### 4.Deleteリクエストでの削除処理

-MethodにてDeleteを指定しリクエストを送信

```PowerShell
$body = @{
  id = 1
  } | ConvertTo-Json
```
<sub>指定するカラム名はDTOオブジェクトで定義したフィールドと合わせる</sub>

```PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/tweets" -Method Delete -Body $body -ContentType "application/json"
```

#### 結果

<img width="300" alt="キャプチャ" src="https://github.com/user-attachments/assets/04fa57bd-5070-4a37-9c59-4d51fd140229">

## 🏫 (必要そうな)クラスの解説

### TweetInteractor

基本的な構造でいうところのサービス層にあたります。リポジトリから得たデータをビジネスロジックに併せて実行することができるため、TweetuseCaseにて自由にメソッド名を変えることができます。そうすることで機能要求に合わせたメソッド名をつけることができ、単一責任の原則に則らせやすくなります。

### TweetRequestDTO・TweetResponseDTO

EntityとControllerの依存性をなくすことでクリーンアーキテクチャに近しい状態にしつつも、リクエストをエンティティのように扱うことを可能にするクラスです。疑似的なものなので、Entity内の必要な情報のみを取捨選択することもできます。

