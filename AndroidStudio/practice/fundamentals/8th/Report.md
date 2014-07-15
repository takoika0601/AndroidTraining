Practice Report for 2/8
------

実習のレポートを下記に記述してください

### Service

1. サンプルプロジェクト (ServiceSample) に、サービスのライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように表示されるかをレポートしてください。

StartedService:
onCreate
onStartCommand
onDestroy

BoundService:
oCreate
onServiceConnected
onUnbind
onDestroy

MyIntentService:
onCreate
onStartCommand
onHandleIntent
onDestroy

### Loader

1. サンプルプロジェクト (LoaderSample) に、AsyncTaskLoader のライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように出力されているかをレポートしてください。

onCreateLoader
onStartLoading
loadInBackground
deliverResult
onLoadFinished
onStopLoading

### AsyncTask

1. `AsyncTask#doInBackground()` で、TextView の文字を変更するような、UI の処理を実行するとどうなるかを、理由を添えてレポートしてください。

UIを処理するのはメインスレッドである。
今回の場合、`AsyncTask#doInBackground()`の処理はワーカースレッド上で実行されるために、UIを変更しようとすると例外が発生し正常に動作しない。
動作させる場合には`AsyncTask#onPreExecute`内もしくは、`AsyncTask#onProgressUpdate`内、`AsyncTask#onPostExecute`内でTextViewの変更処理を行う必要がある。
