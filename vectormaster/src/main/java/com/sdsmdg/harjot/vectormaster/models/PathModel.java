package com.sdsmdg.harjot.vectormaster.models;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.sdsmdg.harjot.vectormaster.DefaultValues;
import com.sdsmdg.harjot.vectormaster.utilities.PathParser;
import com.sdsmdg.harjot.vectormaster.utilities.Utils;

public class PathModel {

    private String name;

    private float fillAlpha;
    private int fillColor;

    private Path.FillType fillType;

    private String pathData;

    private float strokeAlpha;
    private int strokeColor;
    private Paint.Cap strokeLineCap;
    private Paint.Join strokeLineJoin;
    private float strokeMiterLimit;
    private float strokeWidth;

    // Support for trim-paths is not available

    private Path path;
    private Paint pathPaint;

    public PathModel() {
        fillAlpha = DefaultValues.PATH_FILL_ALPHA;
        fillColor = DefaultValues.PATH_FILL_COLOR;
        fillType = DefaultValues.PATH_FILL_TYPE;
        strokeAlpha = DefaultValues.PATH_STROKE_ALPHA;
        strokeColor = DefaultValues.PATH_STROKE_COLOR;
        strokeLineCap = DefaultValues.PATH_STROKE_LINE_CAP;
        strokeLineJoin = DefaultValues.PATH_STROKE_LINE_JOIN;
        strokeMiterLimit = DefaultValues.PATH_STROKE_MITER_LIMIT;
        strokeWidth = DefaultValues.PATH_STROKE_WIDTH;

        pathPaint = new Paint();
        updatePaint();
    }

    public void buildPath() {
        path = PathParser.createPathFromPathData(pathData);
        if (path != null)
            path.setFillType(fillType);
    }

    public void updatePaint() {
        pathPaint.setAntiAlias(true);
        pathPaint.setStrokeWidth(strokeWidth);
        pathPaint.setColor((fillColor == Color.TRANSPARENT) ? strokeColor : fillColor);
        pathPaint.setAlpha((fillColor == Color.TRANSPARENT) ? Utils.getAlphaFromFloat(strokeAlpha) : Utils.getAlphaFromFloat(fillAlpha));

        pathPaint.setStyle((fillColor == Color.TRANSPARENT) ? Paint.Style.STROKE : Paint.Style.FILL);

        pathPaint.setStrokeCap(strokeLineCap);
        pathPaint.setStrokeJoin(strokeLineJoin);
        pathPaint.setStrokeMiter(strokeMiterLimit);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Paint getPathPaint() {
        return pathPaint;
    }

    public void setPathPaint(Paint pathPaint) {
        this.pathPaint = pathPaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFillAlpha() {
        return fillAlpha;
    }

    public void setFillAlpha(float fillAlpha) {
        this.fillAlpha = fillAlpha;
        updatePaint();
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
        updatePaint();
    }

    public Path.FillType getFillType() {
        return fillType;
    }

    public void setFillType(Path.FillType fillType) {
        this.fillType = fillType;
        if (path != null)
            path.setFillType(fillType);
    }

    public String getPathData() {
        return pathData;
    }

    public void setPathData(String pathData) {
        this.pathData = pathData;
    }

    public float getStrokeAlpha() {
        return strokeAlpha;
    }

    public void setStrokeAlpha(float strokeAlpha) {
        this.strokeAlpha = strokeAlpha;
        updatePaint();
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        updatePaint();
    }

    public Paint.Cap getStrokeLineCap() {
        return strokeLineCap;
    }

    public void setStrokeLineCap(Paint.Cap strokeLineCap) {
        this.strokeLineCap = strokeLineCap;
        updatePaint();
    }

    public Paint.Join getStrokeLineJoin() {
        return strokeLineJoin;
    }

    public void setStrokeLineJoin(Paint.Join strokeLineJoin) {
        this.strokeLineJoin = strokeLineJoin;
        updatePaint();
    }

    public float getStrokeMiterLimit() {
        return strokeMiterLimit;
    }

    public void setStrokeMiterLimit(float strokeMiterLimit) {
        this.strokeMiterLimit = strokeMiterLimit;
        updatePaint();
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        updatePaint();
    }
}
