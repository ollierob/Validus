const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: {
        main: ["./src/main/js/main/Main.tsx"]
    },
    output: {
        path: __dirname + "/target/classes/js",
        filename: "[name].[contenthash].bundle.js",
        chunkFilename: "[name].[contenthash].bundle.js",
    },
    resolve: {
        extensions: [".ts", ".tsx", ".js", ".json", ".less"]
    },
    optimization: {
        splitChunks: {
            chunks: "all",
            maxInitialRequests: Infinity,
            minSize: 0,
            maxSize: 1000000,
            cacheGroups: {
                vendor: {
                    name: "vendors",
                    test: /node_modules/
                }
            }
        }
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
    plugins: [
        new HtmlWebpackPlugin({
            inject: false,
            chunks: ["main"],
            publicPath: "/js",
            template: "src/main/resources/page.html.template",
            filename: "main.html"
        })
    ]
}