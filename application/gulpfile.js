const gulp = require('gulp');
const path = require('path');
const browserify = require('browserify');
const glob = require('glob');
const source = require('vinyl-source-stream');
const es = require('event-stream');
const buffer = require('vinyl-buffer');
const rename = require('gulp-rename');

gulp.task('umd', done => {
    glob('./forms/**.jsx', (err, files) => {
    if(err) (done(err));

    const tasks = files.map(entry => {
            return browserify({
                entries: [entry],
                standalone: path.basename(entry, '.jsx'),
                external: ['react']
            })
                .transform('babelify', { presets: [ "react", "es2015" ] })
                .bundle()
                .pipe(source(entry))
                .pipe(rename({
                    extname: '.js'
                }))
                .pipe(gulp.dest('./src/main/webapp'))
        });
    es.merge(tasks).on('end', done);
    })
});