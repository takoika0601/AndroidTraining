Practice Report for 2.4
------

実習のレポートを下記に記述してください

Intent に、Intent.FLAG_ACTIVITY_NO_HISTORY という flag をセットするとどうなるかレポートすること

以下記述
Intent.FLAG_ACTIVITY_NO_HISTORYがセットされたIntentによるActivityの呼び出しでは、画面遷移の状態が記憶されない。例えば、ユーザがホームボタンを押し、その後Activityに戻ってきたとき、NewActivity3に遷移した状態ではなく、MainActivityから再開される。