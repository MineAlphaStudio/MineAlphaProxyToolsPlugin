Set-Location "D:\MineAlphaProxyPlugins\MineAlphaProxyTools"
.\gradlew.bat clean build
if ($LASTEXITCODE -eq 0) {
    Copy-Item "build\libs\MineAlphaProxyTools-1.0.0.jar" "D:\MineAlphaProxy1\MineAlphaPlugins\" -Force
    Write-Host "Скопировано в MineAlphaPlugins" -ForegroundColor Green
}
