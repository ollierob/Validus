const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    output: {
        path: __dirname + "/target/classes/js",
        filename: "[name].[contenthash].bundle.js",
        chunkFilename: "[name].[contenthash].bundle.js",
    },
    resolve: {
        extensions: [".ts", ".tsx", ".js", ".json", ".less"]
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: ["ts-loader"]
            },
            {
                test: /\.css$/,
                use: ["style-loader", "css-loader"]
            }
        ]
    },
    mode: 'development',
    devtool: 'inline-source-map'
}